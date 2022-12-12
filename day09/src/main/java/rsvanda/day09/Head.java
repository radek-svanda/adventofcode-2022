package rsvanda.day09;

public class Head {

    private final Tail tail;

    protected Cell position;

    public Head(Tail tail) {
        this.tail = tail;
        this.position = Cell.start;
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
}
