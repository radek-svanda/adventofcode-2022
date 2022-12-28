package rsvanda.day15;

import rsvanda.InputStreams;

import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public record BeaconDetector(List<Sensor> sensors, List<Beacon> beacons) {

    public long coveredOnRow(long y) {

        List<Long> xs = Stream.concat(sensors.stream(), beacons.stream()).mapToLong(Point::x).boxed().toList();

        long from = xs.stream().min(Comparator.comparingLong(o -> o)).orElseThrow();
        long to = xs.stream().max(Comparator.comparingLong(o -> o)).orElseThrow();

        return LongStream.range(from, to + 1)
                .filter(x -> !hasBeacon(x, y))
                .filter(x -> hasCover(x, y))
                .count();
    }

    boolean hasCover(long x, long y) {
        return sensors.stream().anyMatch(it -> it.covers(x, y));
    }

    private boolean hasBeacon(long x, long y) {
        return beacons.stream().anyMatch(it -> it.x() == x && it.y() == y);
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
