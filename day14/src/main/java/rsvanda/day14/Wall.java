package rsvanda.day14;

import java.util.*;

public record Wall(List<Edge> edges) {

    public static Wall parse(String source) {
        List<Edge> edges = Arrays.stream(source.split("->"))
                .map(String::trim)
                .map(Edge::parse)
                .toList();
        return new Wall(edges);
    }

    public List<Edge> allEdges() {

        return edges.stream()
                .reduce(
                        new LinkedList<>(),
                        (list, current) -> {
                            if (!list.isEmpty()) {
                                Edge last = list.removeLast();
                                List<Edge> link = link(last, current);
                                list.addAll(link);
                            } else {
                                list.addLast(current);
                            }
                            return list;
                        },
                        (edges1, edges2) -> {
                            LinkedHashSet<Edge> set = new LinkedHashSet<>();
                            set.addAll(edges1);
                            set.addAll(edges2);
                            return new LinkedList<>(set);
                        }
                );
    }

    static List<Edge> link(Edge from, Edge to) {
        Set<Edge> list = new LinkedHashSet<>();
        list.add(from);

        if (from.y() > to.y()) {
            for (int i = to.y() + 1; i < from.y(); i++) {
                list.add(new Edge(from.x(), i));
            }
        } else {
            for (int i = from.y() + 1; i < to.y(); i++) {
                list.add(new Edge(from.x(), i));
            }
        }

        if (from.x() > to.x()) {
            for (int i = to.x() + 1; i < from.x(); i++) {
                list.add(new Edge(i, from.y()));
            }
        } else {
            for (int i = from.x() + 1; i < to.x(); i++) {
                list.add(new Edge(i, from.y()));
            }
        }

        list.add(to);

        return new ArrayList<>(list);
    }

}
