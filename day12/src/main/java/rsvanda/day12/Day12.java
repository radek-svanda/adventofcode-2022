package rsvanda.day12;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Stream;

public class Day12 {

    public static void main(String[] args) {
        InputStream stream = Day12.class.getResourceAsStream("/input.txt");
        PathTree tree = PathTree.read(stream);

        firstPart(tree);
        secondPart(tree);
    }

    private static void firstPart(PathTree tree) {
//        InputStream stream = Day12.class.getResourceAsStream("/input.txt");

//        PathTree tree = PathTree.read(stream);
        System.out.println(tree.size());

        var strategy = new BreadthFirstSearch();
        var end = strategy.findEnd(tree.start());
        System.out.println(Node.countParents(end.get()));
    }

    private static void secondPart(PathTree tree) {
        var strategy = new BreadthFirstSearch();
        List<Node> aNodes = tree.nodes(it -> it.getValue() == 'a').toList();
        Map<Node, Integer> map = strategy.lengths(aNodes);
        System.out.println("Got maps");
        int min = map.values().stream().mapToInt(it -> it).min().orElseThrow();
        System.out.println(min);
    }

}
