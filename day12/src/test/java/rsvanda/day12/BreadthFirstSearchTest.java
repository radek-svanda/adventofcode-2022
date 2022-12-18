package rsvanda.day12;

import org.junit.jupiter.api.Test;
import rsvanda.Strings;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    private String example = """
            Sabqponm
            abcryxxl
            accszExk
            acctuvwj
            abdefghi
            """;

    @Test
    void testExecution() {
        PathTree tree = PathTree.read(Strings.stringToStream(example));
        var strategy = new BreadthFirstSearch();
        var end = strategy.findEnd(tree.start());
        assertEquals(31, Node.countParents(end));
    }
}