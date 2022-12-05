package rsvanda.day05;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StacksTest {

    @Test
    void testFactory() {
        String input = """
                                [V]     [C]     [M]
                [V]     [J]     [N]     [H]     [V]
                [R] [F] [N]     [W]     [Z]     [N]
                [H] [R] [D]     [Q] [M] [L]     [B]
                [B] [C] [H] [V] [R] [C] [G]     [R]
                [G] [G] [F] [S] [D] [H] [B] [R] [S]
                [D] [N] [S] [D] [H] [G] [J] [J] [G]
                [W] [J] [L] [J] [S] [P] [F] [S] [L]
                 1   2   3   4   5   6   7   8   9""";
        Stacks stacks = Stacks.parse(input);

        System.out.println(input);
        System.out.println(stacks);
        assertAll(
                () -> assertEquals(
                        "VFJVVMCRM",
                        stacks.getTopCrates().stream().map(Object::toString).collect(Collectors.joining())
                )
        );
    }

}