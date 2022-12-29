package rsvanda.day15;

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
}
