package rsvanda.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day14Test {

    @Test
    void part1() {
        assertEquals(979, new Day14.Part1().solve());
    }

    @Test
    void part2() {
        assertEquals(29044, (new Day14.Part2().solve()));
    }

}