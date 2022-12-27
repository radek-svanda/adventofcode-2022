package rsvanda.day14;

import rsvanda.Resources;

import java.util.List;

public class Day14 {

    public static class Part1 {

        public int solve() {
            List<Wall> walls = Resources.readLines("/input.txt")
                    .map(Wall::parse)
                    .toList();

            Grid grid = new Grid();
            walls.forEach(grid::addWall);
            Sand sand = new Sand(grid);
            return sand.dropUntilOverflow();
        }

    }

    public static class Part2 {

    }

    public static void main(String[] args) {
        new Part1().solve();
    }

}
