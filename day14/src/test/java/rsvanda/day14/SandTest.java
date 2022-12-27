package rsvanda.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SandTest {

    List<Wall> walls = List.of(
            Wall.parse("498,4 -> 498,6 -> 496,6"),
            Wall.parse("503,4 -> 502,4 -> 502,9 -> 494,9")
    );
    private Grid grid;
    private Sand sand;

    @BeforeEach
    void setup() {
        grid = new Grid();
        walls.forEach(grid::addWall);
        sand = new Sand(grid);
        Dump.dump(grid);
    }

    void assertDrop(Edge expected) {
        Edge edge = sand.drop();
        Dump.dump(grid);
        assertEquals(expected, edge);
    }

    void assertDrop(Edge expected, int count) {
        Edge reduce = sand.dropUntil(count);
        Dump.dump(grid);
        assertEquals(expected, reduce);
    }

    @Test
    void drops() {

        assertDrop(new Edge(500, 8));
        assertDrop(new Edge(499, 8));

        assertDrop(new Edge(498, 8), 5);
        assertDrop(new Edge(500, 2), 22);

        sand.drop();
        Dump.dump(grid);

        assertDrop(new Edge(495, 8));

        boolean fail = false;
        try {
            sand.drop();
        } catch (IllegalStateException e) {
            fail = true;
        }

        assertTrue(fail);

    }

    @Test
    void fill() {
        grid.setBottom(grid.lowest() + 2);
        assertEquals(9, grid.lowest());
        assertEquals(11, grid.bottom());
        assertEquals(93, sand.dropUntilFull());
        Dump.dump(grid);
    }

}