package rsvanda.day09;

import java.util.Set;

public class TailDump {

    private TailDump() {
    }

    public static void dump(Knot tail) {
        int minX = tail.getVisited().stream().mapToInt(Cell::x).min().orElse(0);
        int maxX = tail.getVisited().stream().mapToInt(Cell::x).max().orElse(0);
        int minY = tail.getVisited().stream().mapToInt(Cell::y).min().orElse(0);
        int maxY = tail.getVisited().stream().mapToInt(Cell::y).max().orElse(0);

        for (int y = maxY; y >= minY; y--) {
            for (int x = minX; x <= maxX; x++) {
                System.out.print(x == 0 && y == 0 ? "s" : hasVisited(tail.getVisited(), x, y) ? "#" : ".");
            }
            System.out.println();
        }
    }

    private static boolean hasVisited(Set<Cell> visited, int x, int y) {
        return visited.stream().anyMatch(cell -> cell.x() == x && cell.y() == y);
    }
}
