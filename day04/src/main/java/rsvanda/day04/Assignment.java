package rsvanda.day04;

import java.util.Collection;
import java.util.stream.IntStream;

public record Assignment(Integer from, Integer to) {

    public static Assignment parse(String input) {
        String[] chunk = input.split("-");
        return new Assignment(
                Integer.parseInt(chunk[0]),
                Integer.parseInt(chunk[1])
        );
    }

    public Collection<Integer> getSections() {
        return IntStream.range(from, to + 1).boxed().toList();
    }
}
