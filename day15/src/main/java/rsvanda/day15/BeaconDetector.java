package rsvanda.day15;

import rsvanda.InputStreams;

import java.io.InputStream;
import java.util.List;

public record BeaconDetector(List<Sensor> sensors, List<Beacon> beacons) {

    public long coveredOnRow(long y) {
        List<Long> beaconX = beacons(y);
        // 800ms
        return sensors.stream()
                .flatMapToLong(it -> it.intersection(y))
                .distinct()
                .filter(x -> !beaconX.contains(x))
                .count();
    }

    boolean hasCover(long x, long y) {
        return sensors.stream().anyMatch(it -> it.covers(x, y));
    }

    private boolean hasBeacon(long x, long y) {
        return beacons.stream().anyMatch(it -> it.x() == x && it.y() == y);
    }

    private List<Long> beacons(long y) {
        return beacons.stream().filter(it -> it.y() == y).map(Point::x).toList();
    }

    public static BeaconDetector from(InputStream stream) {
        List<InputRow> list = InputStreams.streamToList(stream, InputRow::parse);
        list.forEach(input -> input.sensor().beacon(input.beacon()));
        return new BeaconDetector(
                list.stream().map(InputRow::sensor).toList(),
                list.stream().map(InputRow::beacon).toList()
        );
    }
}
