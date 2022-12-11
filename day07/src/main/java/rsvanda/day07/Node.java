package rsvanda.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Node {

    private final String name;

    protected Long size = 0L;

    private final Node.Dir parent;

    private Node(String name, Dir parent) {
        this.name = name;
        this.parent = parent;
    }

    public Long size() {
        return size;
    }

    public Node.Dir parent() {
        return parent;
    }

    public String name() {
        return name;
    }

    protected boolean isDir() {
        return false;
    }

    public static class Dir extends Node {

        private final List<Node> nodes = new ArrayList<>();

        public Dir(String name, Dir parent) {
            super(name, parent);
        }

        public void add(Node node) {
            nodes.add(node);
            addSize(node.size());
        }

        private void addSize(Long size) {
            this.size += size;
            Optional.ofNullable(parent()).ifPresent(it -> it.addSize(size));
        }

        public Optional<Dir> getDir(String name) {
            return nodes.stream()
                    .filter(it -> it instanceof Node.Dir)
                    .filter(n -> n.name.equals(name))
                    .map(Node.Dir.class::cast)
                    .findFirst();
        }

        @Override
        public String toString() {
            return name() + " (dir, size=" + size() + ")";
        }

        public List<Node> nodes() {
            return nodes;
        }

        @Override
        protected boolean isDir() {
            return true;
        }

        public List<Dir> getDirs() {
            List<Node.Dir> dirs = new ArrayList<>();
            collectDirs(dirs);
            return dirs;
        }

        private void collectDirs(List<Node.Dir> dirs) {
            dirs.add(this);
            nodes.stream().filter(Node::isDir)
                    .map(Dir.class::cast)
                    .forEach(it -> it.collectDirs(dirs));
        }
    }

    public static class File extends Node {

        public File(String name, Dir parent, Long size) {
            super(name, parent);
            this.size = size;
        }

        @Override
        public String toString() {
            return name() + " (file, size=" + size() + ")";
        }
    }
}
