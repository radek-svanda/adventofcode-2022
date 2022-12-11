package rsvanda.day07;

import java.util.List;

public class Parser {

    private Node.Dir root;
    private Node.Dir current;

    public void parse(List<String> rows) {
        rows.forEach(row -> {
            String[] chunks = row.split(" ");
            switch (chunks[0]) {
                case "$" -> command(chunks[1], chunks.length > 2 ? chunks[2] : "");
                case "dir" -> current.add(new Node.Dir(chunks[1], current));
                default -> current.add(new Node.File(chunks[1], current, Long.parseLong(chunks[0])));
            }
        });
    }

    private void command(String command, String param) {
        switch (command) {
            case "cd" -> {
                switch (param) {
                    case "/" -> {
                        root = new Node.Dir("/", null);
                        current = root;
                    }
                    case ".." -> current = current.parent();
                    default -> current = current.getDir(param).orElseThrow();
                }
            }
            case "ls" -> {
                // no action needed
            }
            default -> throw new IllegalStateException();
        }
    }

    public Node.Dir root() {
        return root;
    }

}
