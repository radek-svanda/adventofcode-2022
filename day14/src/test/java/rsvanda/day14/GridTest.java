package rsvanda.day14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridTest {

    @Test
    void draw() {
        List<Wall> walls = List.of(
                Wall.parse("498,4 -> 498,6 -> 496,6"),
                Wall.parse("503,4 -> 502,4 -> 502,9 -> 494,9")
        );

        Grid grid = new Grid();
        walls.forEach(grid::addWall);
        Dump.dump(grid);

        Edge sand = grid.drop();
        Dump.dump(grid);
        assertEquals(new Edge(500, 8), sand);

        sand = grid.drop();
        Dump.dump(grid);
        assertEquals(new Edge(499, 8), sand);

        Edge reduce = grid.dropUntil(5);
        Dump.dump(grid);
        assertEquals(new Edge(498, 8), reduce);

        sand = grid.dropUntil(22);
        Dump.dump(grid);
        assertEquals(new Edge(500, 2), sand);

        grid.drop();
        Dump.dump(grid);

        sand = grid.drop();
        Dump.dump(grid);
        assertEquals(new Edge(495, 8), sand);

        boolean fail = false;
        try {
            grid.drop();
        } catch (IllegalStateException e) {
            fail = true;
        }

        assertTrue(fail);

    }

}