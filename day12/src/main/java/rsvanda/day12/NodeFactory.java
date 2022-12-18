package rsvanda.day12;

import java.util.HashSet;
import java.util.Set;

public class NodeFactory {

    private final Set<Node> nodes = new HashSet<>();

    public Node get(int x, int y, char value) {
        return nodes.stream()
                .filter(it -> it.x() == x && it.y() == y)
                .findFirst()
                .orElseGet(() -> {
                    Node n = new Node(x, y, value);
                    nodes.add(n);
                    return n;
                });
    }

    public Set<Node> getNodes() {
        return nodes;
    }
}
