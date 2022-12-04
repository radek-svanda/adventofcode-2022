package rsvanda.day04;

import java.util.ArrayList;
import java.util.List;

public record Pair(Assignment first, Assignment second) {

    public static Pair parse(String row) {
        String[] chunks = row.split(",");
        return new Pair(
                Assignment.parse(chunks[0]),
                Assignment.parse(chunks[1])
        );
    }

    public boolean fullyOverlap() {
        return first.getSections().containsAll(second.getSections())
                || second.getSections().containsAll(first.getSections());
    }

    public boolean partiallyOverlap() {
        List<Integer> firstSections = new ArrayList<>(first.getSections());
        return firstSections.removeAll(second.getSections());
    }
}
