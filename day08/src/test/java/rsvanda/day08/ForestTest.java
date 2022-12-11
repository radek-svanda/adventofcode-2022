package rsvanda.day08;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ForestTest {

    String data = """
                30373
                25512
                65332
                33549
                35390
                """;

    Forest forest = Forest.read(new ByteArrayInputStream(data.getBytes()));

    @Test
    void testBuilder() {
        assertEquals(25, forest.trees().size());
    }

    @Test
    void testVisible() {
        assertEquals(21, forest.getVisible().size());
    }

    @Test
    void testView() {
        assertEquals(8, forest.maxView());
    }

}