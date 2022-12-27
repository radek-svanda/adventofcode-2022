package rsvanda.day14;

public class Dump {

    public static void dump(Grid grid) {
        Edge min = grid.min();
        Edge max = grid.max();

        for (int y = min.y(); y <= max.y(); y++) {
            for (int x = min.x(); x <= max.x(); x++) {
                System.out.print(grid.get(new Edge(x, y)).sign());
            }
            System.out.println();
        }

        System.out.println();
    }

}
