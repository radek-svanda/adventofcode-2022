package rsvanda.day15;

import rsvanda.InputStreams;

import java.io.InputStream;
import java.util.List;

public record BeaconDetector(List<Sensor> sensors, List<Beacon> beacons) {

    public long coveredOnRow(long y) {
        // 40ms
        return interval(y).size() - beacons(y).size();
    }

    private Interval interval(long y) {
        return sensors.stream()
                .map(it -> it.interval(y))
                .reduce(new Interval(),
                        (interval, interval2) -> {
                            interval.append(interval2);
                            return interval;
                        }
                );
    }

    public long findFrequency(long from, long to) {
        // 9sec
        for (long y = from; y <= to; y++) {
            Interval interval = interval(y).sub(from, to);
            List<Long> gaps = interval.gaps();
            if (!gaps.isEmpty()) {
                return 4000000L * gaps.get(0) + y;
            }
        }
        return -1;
    }

    boolean hasCover(long x, long y) {
        return sensors.stream().anyMatch(it -> it.covers(x, y));
    }

    private List<Long> beacons(long y) {
        return beacons.stream().filter(it -> it.y() == y).map(Point::x).toList();
    }

    public static BeaconDetector from(InputStream stream) {
        List<InputRow> list = InputStreams.streamToList(stream, InputRow::parse);
        list.forEach(input -> input.sensor().beacon(input.beacon()));
        return new BeaconDetector(
                list.stream().map(InputRow::sensor).toList(),
                list.stream().map(InputRow::beacon).sorted().distinct().toList()
        );
    }
}
