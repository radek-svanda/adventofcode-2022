package rsvanda.day12;

import org.junit.jupiter.api.Test;
import rsvanda.Strings;

import java.util.Map;

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
        assertEquals(31, Node.countParents(end.get()));
    }

    @Test
    void testSecondExecution() {
        PathTree tree = PathTree.read(Strings.stringToStream(example));
        var strategy = new BreadthFirstSearch();

        Map<Node, Integer> map = strategy.lengths(tree.nodes(it -> it.getValue() == 'a').toList());

        System.out.println(map.values().stream().mapToInt(it -> it).min());
//        assertEquals(31, Node.countParents(end));
    }
}