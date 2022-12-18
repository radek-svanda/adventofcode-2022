package rsvanda.day12;

import java.util.LinkedList;

public class BreadthFirstSearch {

    public Node findEnd(Node start) {
        final var queue = new LinkedList<Node>();
        start.visited(true);
        queue.addLast(start);
        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            if (current.isEnd()) {
                return current;
            }
            current.getNextNodes().stream()
                    .filter(n -> !n.visited())
                    .forEach(n -> {
                        n.visited(true);
                        n.setParent(current);
                        queue.addLast(n);
                    });
        }
        throw new IllegalStateException("Cannot reach end");
    }
}
