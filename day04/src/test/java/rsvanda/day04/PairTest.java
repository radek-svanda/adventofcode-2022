package rsvanda.day04;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTest {

    @ParameterizedTest
    @ValueSource(strings = {"2-8,3-7", "6-6,4-6"})
    void fullyOverlapping(String row) {
        assertTrue(Pair.parse(row).fullyOverlap());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2-4,6-8", "2-6,4-8"})
    void notFullyOverlapping(String row) {
        assertFalse(Pair.parse(row).fullyOverlap());
    }

    @ParameterizedTest
    @ValueSource(strings = {"5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8"})
    void partiallyOverlapping(String row) {
        assertTrue(Pair.parse(row).partiallyOverlap());
    }

}