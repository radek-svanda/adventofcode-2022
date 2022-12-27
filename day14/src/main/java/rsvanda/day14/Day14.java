package rsvanda.day14;

import rsvanda.Resources;

import java.util.List;

public class Day14 {

    public static class Part1 {

        public void solve() {
            List<Wall> walls = Resources.readLines("/input.txt")
                    .map(Wall::parse)
                    .toList();

            Grid grid = new Grid();
            walls.forEach(grid::addWall);

            int i = 0;
            try {
                while (grid.drop() != null) {
                    i++;
                }
            } catch (IllegalStateException e) {
                 // 979
            }

            System.out.println(i);
        }

    }

    public static class Part2 {

    }

    public static void main(String[] args) {
        new Part1().solve();
    }

}
