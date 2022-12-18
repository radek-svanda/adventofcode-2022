package rsvanda.day12;

import java.util.*;

public final class Node {
    private final int x;
    private final int y;

    private final char value;

    private int pathLength = Integer.MIN_VALUE;

    private final boolean start;

    private final boolean end;

    private final List<Node> nextNodes = new ArrayList<>(4);

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
        return this.pathLength > 0;
    }

    public boolean impossible() {
        return this.pathLength == Integer.MAX_VALUE;
    }

    public int getPathLength() {
        return this.getPathLength(new LinkedList<>());
    }

    private int getPathLength(Deque<Node> parents) {
        if (visited()) {
            return pathLength;
        }

        if (nextNodes.stream().anyMatch(Node::isEnd)) {
            pathLength = 1;
        } else {
            parents.addLast(this);
            System.out.println(".".repeat(parents.size()));
            pathLength = nextNodes.stream()
                    .filter(it -> !parents.contains(it))
                    .mapToInt(it -> it.getPathLength(parents))
                    .min()
                    .orElse(Integer.MAX_VALUE) + 1;
            parents.removeLast();
        }

        return pathLength;
    }

    public void addNext(Node next) {
        if (!nextNodes.contains(next) && canBeNext(next.value)) {
            nextNodes.add(next);
        }
    }

    public boolean isEnd() {
        return end;
    }

    public boolean isStart() {
        return start;
    }

    private boolean canBeNext(char other) {
        return this.value + 1 >= other;
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
}
