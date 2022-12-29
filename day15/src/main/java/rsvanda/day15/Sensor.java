package rsvanda.day15;

import java.util.stream.LongStream;

import static java.lang.Math.abs;

public final class Sensor extends Point {

    private long range = -1;

    public Sensor(long x, long y) {
        super(x, y);
    }

    public void beacon(Beacon beacon) {
        this.range = distance(beacon);
    }

    public long minX() {
        return x() - range;
    }

    public long maxX() {
        return x() + range;
    }

    public boolean covers(long x, long y) {
        return distance(x, y) <= range;
    }

    public long distance(Point other) {
        return distance(other.x(), other.y());
    }

    private long distance(long x, long y) {
        return abs(x - x()) + abs(y - y());
    }

    public LongStream intersection(long y) {
        if (!covers(x(), y)) {
            return LongStream.empty();
        } else {
            long distance = distance(x(), y);
            long diff = range - distance;
            return LongStream.range(x() - diff, x() + diff + 1);
        }
    }
}
