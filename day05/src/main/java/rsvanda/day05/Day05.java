package rsvanda.day05;

import rsvanda.Resources;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Day05 {

    private static final Predicate<String> notEmpty = str -> !"".equals(str);

    public static void main(String[] args) {

        List<Move> moves = readMoves();

        Stacks stacks = readStacks();
        System.out.println(stacks);
        moves.forEach(move -> stacks.move(move.count(), move.from(), move.to()));

        printTops(stacks);

        Stacks stacks2 = readStacks();
        moves.forEach(move -> stacks2.moveMultiple(move.count(), move.from(), move.to()));

        printTops(stacks2);

    }

    private static void printTops(Stacks stacks) {
        System.out.println(stacks.getTopCrates().stream().map(Crate::stringValue).collect(Collectors.joining()));
    }

    private static List<Move> readMoves() {
        return Resources.readLines("/input.txt")
                .dropWhile(notEmpty)
                .filter(notEmpty)
                .map(Move::parse)
                .toList();
    }

    private static Stacks readStacks() {
        return Stacks.parse(Resources.readLines("/input.txt")
                .takeWhile(notEmpty)
                .collect(Collectors.joining("\n")));
    }

}
