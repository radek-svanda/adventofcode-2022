package rsvanda.day15;

public final class Beacon extends Point implements Comparable<Beacon> {

    public Beacon(long x, long y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Beacon other) {
            return other.x() == x() && other.y() == y();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) (7 * x() + 13 * y());
    }

    @Override
    public int compareTo(Beacon o) {
        return (int) ((y() - o.y()) + (x() - o.x()));
    }
}
