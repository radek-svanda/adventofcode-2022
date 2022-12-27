package rsvanda.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class Grid {

    private final Map<Edge, Item> cells = new HashMap<>();

    private int bottom = 0;

    public void addWall(Wall wall) {
        wall.allEdges().forEach(edge -> cells.put(edge, Item.ROCK));
        bottom = cells.keySet().stream().mapToInt(Edge::y).max().orElse(bottom);
    }

    public Item get(Edge edge) {
        return Optional.ofNullable(cells.get(edge))
                .orElseGet(() -> set(edge, Item.AIR));
    }

    private Item set(Edge edge, Item type) {
        cells.put(edge, type);
        return type;
    }

    public Edge drop() {
        return sand(Edge.START);
    }

    public Edge dropUntil(int cnt) {
        return IntStream.range((int) sandCount(), cnt).boxed()
                .reduce(Edge.START, (edge, integer) -> drop(), (edge, edge2) -> edge2);
    }

    private Edge sand(Edge edge) {

        if (edge.y() > bottom) {
            throw new IllegalStateException("Overflows!");
        }

        if (get(edge.down()).free()) {
            return sand(edge.down());
        } else if (get(edge.left().down()).free()) {
            return sand(edge.left().down());
        } else if (get(edge.right().down()).free()) {
            return sand(edge.right().down());
        }

        set(edge, Item.SAND);
        return edge;
    }

    public Edge min() {
        return new Edge(
                minEdge(Edge::x),
                minEdge(Edge::y)
        );
    }

    public Edge max() {
        return new Edge(
                maxEdge(Edge::x),
                maxEdge(Edge::y)
        );
    }

    private int minEdge(ToIntFunction<Edge> fn) {
        return cells.keySet().stream().mapToInt(fn).min().orElse(0);
    }

    private int maxEdge(ToIntFunction<Edge> fn) {
        return cells.keySet().stream().mapToInt(fn).max().orElse(0);
    }

    private long sandCount() {
        return cells.values().stream()
                .filter(it -> it == Item.SAND)
                .count();
    }

}
