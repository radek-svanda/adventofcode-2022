package rsvanda.day15;

abstract sealed class Point
        permits Sensor, Beacon {

    private final long x;
    private final long y;

    protected Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long x() {
        return x;
    }

    public long y() {
        return y;
    }
}
