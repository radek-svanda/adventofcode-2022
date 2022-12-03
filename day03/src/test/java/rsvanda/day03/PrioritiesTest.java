package rsvanda.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrioritiesTest {

    @Test
    void testValue() {
        assertEquals(1, Priorities.priorityOf('a'));
        assertEquals(26, Priorities.priorityOf('z'));
        assertEquals(27, Priorities.priorityOf('A'));
        assertEquals(52, Priorities.priorityOf('Z'));
    }

}