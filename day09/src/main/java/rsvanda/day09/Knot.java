package rsvanda.day09;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Knot {

    private final Set<Cell> visited = new HashSet<>();

    private final Knot next;

    private Cell position;

    public Knot() {
        this(null);
    }

    public Knot(Knot next) {
        this.next = next;
        setPosition(Cell.start);
    }

    public void pull(Cell to) {
        setPosition(position.moveTo(to));
        Optional.ofNullable(next)
                .ifPresent(it -> it.pull(position));
    }

    public Set<Cell> getVisited() {
        return Collections.unmodifiableSet(visited);
    }

    public final void setPosition(Cell position) {
        this.position = position;
        this.visited.add(position);
    }

    public Knot next() {
        return next;
    }
}
