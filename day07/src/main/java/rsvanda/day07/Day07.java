package rsvanda.day07;

import rsvanda.Resources;

import java.util.List;

public class Day07 {

    public static void main(String[] args) {

        // should have been visitor pattern :-(

        List<String> rows = Resources.readLines("/input.txt").toList();
        Parser parser = new Parser();
        parser.parse(rows);
        Long total = parser.root().getDirs().stream()
                .map(Node::size)
                .filter(size -> size < 100000)
                .reduce(Long::sum)
                .orElseThrow();

        System.out.println(total);

        DirectoryDumper.dump(parser.root());

        Long totalSpace = 70000000L;
        Long needed = 30000000L;

        Long used = parser.root().size();
        Long free = totalSpace - used;

        System.out.println("Free space: " + free);

        long toFree = needed - free;
        System.out.println("To delete: " + toFree);

        long minSize = parser.root().getDirs().stream()
                .mapToLong(Node::size)
                .filter(it -> it > toFree)
                .min()
                .orElseThrow();

        System.out.println(minSize);

    }
}
