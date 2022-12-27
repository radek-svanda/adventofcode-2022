package rsvanda.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class Grid {

    private final Map<Edge, Item> cells = new HashMap<>();

    private int lowest = 0;

    private int bottom = -1;

    public void addWall(Wall wall) {
        wall.allEdges().forEach(edge -> cells.put(edge, Item.ROCK));
        lowest = cells.keySet().stream().mapToInt(Edge::y).max().orElse(lowest);
    }

    public Item get(Edge edge) {
        return cells.getOrDefault(edge, Item.AIR);
    }

    public Item set(Edge edge, Item type) {
        cells.put(edge, type);
        return type;
    }

    public boolean free(Edge edge) {
        if (bottom > 0) {
            return edge.y() < bottom && get(edge).free();
        } else {
            return get(edge).free();
        }
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

    public long getCount(Item type) {
        return cells.values().stream()
                .filter(it -> it == type)
                .count();
    }

    public int lowest() {
        return lowest;
    }

    public void setBottom(int y) {
        this.bottom = y;
    }

    public int bottom() {
        return bottom;
    }
}
