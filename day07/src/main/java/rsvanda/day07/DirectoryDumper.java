package rsvanda.day07;

public class DirectoryDumper {

    private DirectoryDumper() {
    }

    public static void dump(Node node) {
        dump(node, "");
    }
    private static void dump(Node node, String prefix) {
        System.out.println(prefix + "- " + node);
        if (node instanceof Node.Dir dir) {
            dir.nodes().forEach(it -> dump(it, prefix + "  "));
        }
    }

}
