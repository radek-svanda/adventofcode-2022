package rsvanda.day12;

import java.util.*;

public final class Node {
    private final int x;
    private final int y;

    private final char value;

    private final boolean start;

    private final boolean end;

    private final List<Node> nextNodes = new ArrayList<>(4);

    private Node parent;

    private boolean visited = false;

    public Node(int x, int y, char value) {
        this.x = x;
        this.y = y;
        this.value = switch (value) {
            case 'S' -> 'a';
            case 'E' -> 'z';
            default -> value;
        };
        this.start = value == 'S';
        this.end = value == 'E';
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public boolean visited() {
        return this.visited;
    }

    public void visited(boolean value) {
        this.visited = value;
    }

    public void addNext(Node next) {
        if (!nextNodes.contains(next) && canFollow(next.value)) {
            nextNodes.add(next);
        }
    }

    public boolean isEnd() {
        return end;
    }

    public boolean isStart() {
        return start;
    }

    private boolean canFollow(char other) {
        return this.value + 1 >= other;
    }

    public List<Node> getNextNodes() {
        return nextNodes;
    }

    public Node getParent() {
        return parent;
    }

    public Node setParent(Node parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Node) obj;
        return this.x == that.x &&
                this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", value=" + value +
                '}';
    }

    public static int countParents(Node node) {
        if (node == null) {
            return 0;
        }
        Node parent = node.getParent();
        int cnt = 0;
        while (parent != null) {
            parent = parent.getParent();
            cnt += 1;
        }
        return cnt;
    }
}
