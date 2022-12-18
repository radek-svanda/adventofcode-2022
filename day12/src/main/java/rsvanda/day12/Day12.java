package rsvanda.day12;

import java.io.InputStream;

public class Day12 {

    public static void main(String[] args) {
        InputStream stream = Day12.class.getResourceAsStream("/input.txt");

        PathTree tree = PathTree.read(stream);
        System.out.println(tree.size());

        var strategy = new BreadthFirstSearch();
        var end = strategy.findEnd(tree.start());
        System.out.println(Node.countParents(end));

    }

}
