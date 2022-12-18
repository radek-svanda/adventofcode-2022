package rsvanda.day12;

import org.junit.jupiter.api.Test;
import rsvanda.Strings;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PathTreeTest {

    private String example = """
            Sabqponm
            abcryxxl
            accszExk
            acctuvwj
            abdefghi
            """;

    @Test
    void testConstruction() {
        PathTree tree = PathTree.read(Strings.stringToStream(example));
        assertEquals(0, tree.start().x());
        assertEquals(0, tree.start().y());
        assertEquals(40, tree.size());
    }

    @Test
    void testPath() {
        PathTree tree = PathTree.read(Strings.stringToStream(example));
        assertEquals(31, tree.start().getPathLength());
    }

}