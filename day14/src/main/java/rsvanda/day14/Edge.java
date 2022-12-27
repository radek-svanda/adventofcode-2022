package rsvanda.day14;

public record Edge(int x, int y) {

    public static final Edge START = new Edge(500, 0);

    public static Edge parse(String source) {
        String[] split = source.trim().split(",");
        return new Edge(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    public Edge down() {
        return new Edge(x, y + 1);
    }

    public Edge right() {
        return new Edge(x + 1, y);
    }

    public Edge left() {
        return new Edge(x - 1, y);
    }

}
