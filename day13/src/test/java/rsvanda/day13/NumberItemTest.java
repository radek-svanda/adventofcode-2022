package rsvanda.day13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberItemTest {

    @Test
    void compare() {
        NumberItem that = new NumberItem(1);
        NumberItem other = new NumberItem(2);
        assertTrue(that.compareTo(other) < 0);
    }

}