package rsvanda.day15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputRowTest {

    @Test
    void parser() {
        String source = "Sensor at x=3300107, y=469364: closest beacon is at x=3211831, y=-792661";
        InputRow row = InputRow.parse(source);

        assertAll(
                () -> assertEquals(3300107, row.sensor().x()),
                () -> assertEquals(469364, row.sensor().y()),
                () -> assertEquals(3211831, row.beacon().x()),
                () -> assertEquals(-792661, row.beacon().y())
        );
    }

}