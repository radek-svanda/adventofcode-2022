package rsvanda.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static rsvanda.day09.Cell.cell;

class CellTest {

    @Test
    void testBorder() {
        Cell a = new Cell(1, 1);
        assertAll(
                () -> assertTrue(new Cell(1, 1).borders(a)),
                () -> assertTrue(new Cell(0, 0).borders(a)),
                () -> assertTrue(new Cell(1, 0).borders(a)),
                () -> assertTrue(new Cell(0, 1).borders(a)),
                () -> assertTrue(new Cell(2, 2).borders(a)),

                () -> assertFalse(new Cell(3, 2).borders(a))
        );
    }

    @Test
    void testMoveTo() {
        assertAll(
                () -> assertEquals(cell(2, 1), cell(1, 1).moveTo(cell(3, 1))),
                () -> assertEquals(cell(1, 2), cell(1, 3).moveTo(cell(1, 1))),
                () -> assertEquals(cell(2, 1), cell(3, 1).moveTo(cell(1, 1))),
                () -> assertEquals(cell(2, 2), cell(1, 1).moveTo(cell(2, 3))),
                () -> assertEquals(cell(2, 2), cell(1, 1).moveTo(cell(3, 2)))
        );
    }

}