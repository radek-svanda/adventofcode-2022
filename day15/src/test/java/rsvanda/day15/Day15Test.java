package rsvanda.day15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day15Test {

    @Test
    void part1() {
        assertEquals(4502208, new Day15.Part1().solve());
    }

    @Test
    void part2() {
        assertEquals(13784551204480L, new Day15.Part2().solve());
    }

}