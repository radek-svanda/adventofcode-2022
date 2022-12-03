package rsvanda.day03;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersects {

    private Intersects() {
        // noop
    }

    public static Character intersect(String... strings) {
        if (strings.length < 2) {
            throw new IllegalArgumentException("Pass at least 2 strings");
        }
        Set<Character> first = stringToCharSet(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            first.retainAll(stringToCharSet(strings[i]));
        }

        if (first.size() != 1) {
            throw new IllegalStateException("Unexpected count of overlaps. " +
                    "Found: " + first + " In: " + Arrays.toString(strings));
        }
        return first.stream().findFirst().orElseThrow();
    }

    private static Set<Character> stringToCharSet(String str) {
        return str.chars()
                .mapToObj(it -> (char) it)
                .collect(Collectors.toSet());
    }

    public static Character intersect(List<String> it) {
        return intersect(it.toArray(new String[]{}));
    }
}
