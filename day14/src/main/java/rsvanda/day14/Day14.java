package rsvanda.day14;

import rsvanda.Resources;

import java.util.List;

public class Day14 {

    private static Grid loadGrid() {
        List<Wall> walls = Resources.readLines("/input.txt")
                .map(Wall::parse)
                .toList();

        Grid grid = new Grid();
        walls.forEach(grid::addWall);
        return grid;
    }

    public static class Part1 {

        public int solve() {
            Grid grid = loadGrid();
            Sand sand = new Sand(grid);
            return sand.dropUntilOverflow();
        }

    }

    public static class Part2 {
        public int solve() {
            Grid grid = loadGrid();
            Sand sand = new Sand(grid);
            grid.setBottom(grid.lowest() + 2);
            return sand.dropUntilFull();
        }
    }

    public static void main(String[] args) {
        new Part1().solve();
    }

}
