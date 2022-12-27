package rsvanda.day14;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @Test
    void parser() {
        String source = "479,42 -> 479,33 -> 479,42 -> 481,42 -> 481,32 -> 481,42 -> 483,42 -> 483,34 -> 483,42";
        Wall wall = Wall.parse(source);
        assertAll(
                () -> assertEquals(9, wall.edges().size()),
                () -> assertEquals(483, wall.edges().get(8).x()),
                () -> assertEquals(42, wall.edges().get(0).y())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "502,4:502,9:6",
            "545,109:540,109:6",
            "503,4:502,4:2"
    })
    void linkTest(String source) {

        String[] chunks = source.split(":");

        Edge from = Edge.parse(chunks[0]);
        Edge to = Edge.parse(chunks[1]);

        List<Edge> link = Wall.link(from, to);
        assertAll(
                () -> assertTrue(link.contains(from)),
                () -> assertTrue(link.contains(to)),
                () -> assertEquals(Integer.parseInt(chunks[2]), link.size())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "498,4 -> 498,6 -> 496,6:5"
    })
    void allEdges(String source) {
        String[] split = source.split(":");
        Wall parse = Wall.parse(split[0]);
        assertEquals(Integer.parseInt(split[1]), parse.allEdges().size());
    }

}