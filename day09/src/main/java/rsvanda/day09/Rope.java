package rsvanda.day09;

public class Rope {

    private final Knot tail;

    private Cell position;

    public Rope(Knot tail) {
        this.tail = tail;
    }

    public void move(Move move) {
        move(move.direction(), move.steps());
    }

    public void move(Direction direction, int steps) {
        for (int i = 0; i < steps; i++) {
            position = position.move(direction);
            tail.pull(position);
        }
    }

    public Knot getTail() {
        Knot next = this.tail;
        while (next.next() != null) {
            next = next.next();
        }
        return next;
    }

    public static Rope length(int length) {
        Knot knot = new Knot();
        for (int i = 1; i < length; i++) {
            knot = new Knot(knot);
        }
        return new Rope(knot);
    }

}
