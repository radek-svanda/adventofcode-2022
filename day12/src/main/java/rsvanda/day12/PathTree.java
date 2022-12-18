package rsvanda.day12;

import rsvanda.Grids;

import java.io.InputStream;
import java.util.List;

public class PathTree {

    private final List<Node> nodes;

    public PathTree(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Node start() {
        return nodes.stream().filter(Node::isStart).findFirst().orElseThrow();
    }

    public int size() {
        return this.nodes.size();
    }

    public static PathTree read(InputStream stream) {
        char[][] chars = Grids.charGrid(stream);
        NodeFactory factory = new NodeFactory();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                var current = factory.get(i, j, chars[i][j]);
                if (i > 0) {
                    current.addNext(factory.get(i - 1, j, chars[i - 1][j]));
                }
                if (i < chars.length - 1) {
                    current.addNext(factory.get(i + 1, j, chars[i + 1][j]));
                }
                if (j > 0) {
                    current.addNext(factory.get(i, j - 1, chars[i][j - 1]));
                }
                if (j < chars[i].length - 1) {
                    current.addNext(factory.get(i, j + 1, chars[i][j + 1]));
                }
            }
        }
        return new PathTree(factory.getNodes().stream().toList());
    }

}
