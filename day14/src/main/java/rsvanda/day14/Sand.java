package rsvanda.day14;

import java.util.stream.IntStream;

public class Sand {

    private final Grid grid;

    public Sand(Grid grid) {
        this.grid = grid;
    }

    public Edge drop() {
        return drop(Edge.START);
    }

    private Edge drop(Edge edge) {

        if (edge.y() > grid.bottom()) {
            throw new IllegalStateException("Overflows!");
        }

        if (grid.get(edge.down()).free()) {
            return drop(edge.down());
        } else if (grid.get(edge.left().down()).free()) {
            return drop(edge.left().down());
        } else if (grid.get(edge.right().down()).free()) {
            return drop(edge.right().down());
        }

        grid.set(edge, Item.SAND);
        return edge;
    }

    public Edge dropUntil(int cnt) {
        return IntStream.range((int) grid.getCount(Item.SAND), cnt).boxed()
                .reduce(Edge.START, (edge, integer) -> drop(), (edge, edge2) -> edge2);
    }

    public int dropUntilOverflow() {
        int i = 0;
        try {
            while (drop() != null) {
                i++;
            }
        } catch (IllegalStateException e) {
            System.out.println("Failed with exception: " + e.getMessage());
        }
        return i;
    }

    public int dropUntilFull() {
        return 0;
    }

}
