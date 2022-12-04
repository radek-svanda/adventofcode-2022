package rsvanda.day04;

import rsvanda.Resources;

import java.util.List;

public class Day04 {

    public static void main(String[] args) {
        List<Pair> pairs = Resources.mapLines("/input.txt", Pair::parse);

        long count = pairs.stream()
                .filter(Pair::fullyOverlap)
                .count();

        System.out.println("Total pairs  : " + pairs.size());
        System.out.println("Fully overlap: " + count);

        long partially = pairs.stream()
                .filter(Pair::partiallyOverlap)
                .count();

        System.out.println("Partially overlap: " + partially);

    }
}
