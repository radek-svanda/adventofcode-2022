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

        if (grid.bottom() < 0 && edge.y() > grid.lowest()) {
            throw new IllegalStateException("Overflows!");
        }

        if (grid.free(edge.down())) {
            return drop(edge.down());
        } else if (grid.free(edge.left().down())) {
            return drop(edge.left().down());
        } else if (grid.free(edge.right().down())) {
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
        int i = 1;
        while (drop() != Edge.START) {
            i++;
        }
        return i;
    }

}
