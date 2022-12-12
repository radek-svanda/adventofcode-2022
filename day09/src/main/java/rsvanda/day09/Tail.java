package rsvanda.day09;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tail {

    private final Set<Cell> visited = new HashSet<>();

    protected Cell position;

    public Tail() {
        position = Cell.start;
        visited.add(position);
    }

    public void pull(Cell to) {
        position = position.moveTo(to);
        visited.add(position);
    }

    public Set<Cell> getVisited() {
        return Collections.unmodifiableSet(visited);
    }
}
