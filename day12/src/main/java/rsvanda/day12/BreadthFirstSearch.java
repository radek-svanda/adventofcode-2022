package rsvanda.day12;

import java.util.*;

public class BreadthFirstSearch {

    public Optional<Node> findEnd(Node start) {
        final var visited = new HashSet<Node>();
        final var queue = new LinkedList<Node>();
        visited.add(start);
        queue.addLast(start);
        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            if (current.isEnd()) {
                return Optional.of(current);
            }
            current.getNextNodes().stream()
                    .filter(n -> !visited.contains(n))
                    .forEach(n -> {
                        visited.add(n);
                        n.setParent(current);
                        queue.addLast(n);
                    });
        }
        return Optional.empty();
    }

    public Map<Node, Integer> lengths(List<Node> nodes) {
        Map<Node, Integer> lengths = new HashMap<>(nodes.size());
        for (Node node : nodes) {
            node.setParent(null);
            if (lengths.containsKey(node)) {
                System.out.println("hit");
                continue;
            }
            Optional<Node> end = findEnd(node);
            end.ifPresent(e -> {
                Node parent = e.getParent();
                int c = 1;
                while (parent != null) {
                    if (parent.getValue() == 'a') {
                        lengths.put(node, c);
                    }
                    parent = parent.getParent();
                    c += 1;
                }
            });
        }
        return lengths;
    }
}
