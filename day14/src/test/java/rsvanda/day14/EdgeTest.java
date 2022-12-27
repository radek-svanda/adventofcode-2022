package rsvanda.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void parser() {
        Edge parse = Edge.parse("537,102");
        assertAll(
                () -> assertEquals(537, parse.x()),
                () -> assertEquals(102, parse.y())
        );
    }

}