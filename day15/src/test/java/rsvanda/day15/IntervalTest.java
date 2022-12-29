package rsvanda.day15;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static rsvanda.day15.Interval.Range.*;

class IntervalTest {

    @Nested
    class RangeTest {

        @Test
        void overlaps() {
            assertTrue(range(2, 4).overlaps(range(3, 6)));
            assertTrue(range(3, 6).overlaps(range(2, 4)));
            assertTrue(range(3, 6).overlaps(range(4, 5)));
            assertTrue(range(3, 6).overlaps(range(1, 8)));

            assertFalse(range(1, 2).overlaps(range(3, 4)));
            assertFalse(range(3, 4).overlaps(range(1, 2)));
        }

    }

    @Nested
    class Append {

        @Test
        void size() {
            assertEquals(3, Interval.of(2, 4).size());
        }

        @Test
        void twoSeparate() {
            Interval interval = Interval.of(2, 4);
            interval.append(Interval.of(6, 8));
            assertEquals(6, interval.size());
        }

        @Test
        void twoAdjacent() {
            Interval interval = Interval.of(2, 4);
            interval.append(Interval.of(5, 8));
            assertEquals(7, interval.size());
        }

        @Test
        void twoOverlapping() {
            Interval interval = Interval.of(2, 4);
            interval.append(Interval.of(3, 8));
            assertEquals(7, interval.size());
        }

    }

    @Nested
    class SubRange {

        @Test
        void subinterval() {
            Interval interval = Interval.of(2, 4);
            interval.append(Interval.of(5, 8));
            Interval sub = interval.sub(0, 6);
            assertEquals(5, sub.size());
        }

    }

    @Test
    void gap() {
        Interval interval = Interval.of(2, 4);
        interval.append(Interval.of(6, 8));
        assertAll(
                () -> assertEquals(1, interval.gaps().size()),
                () -> assertEquals(5, interval.gaps().get(0))
        );
    }

}