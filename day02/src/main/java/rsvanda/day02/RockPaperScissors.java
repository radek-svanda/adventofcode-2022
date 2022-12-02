package rsvanda.day02;

import rsvanda.Resources;

import java.util.List;
import java.util.stream.Stream;

public class RockPaperScissors {

    public static void main(String[] args) {
        Integer total = readStrategy().stream().map(Game::score).reduce(0, Integer::sum);
        System.out.println("Total score " + total);

        Integer max = readFinishStrategy().stream().map(Game::score).reduce(0, Integer::sum);
        System.out.println("Max score " + max);
    }

    static List<Game> readStrategy() {
        try (Stream<String> lines = Resources.readLines("/strategy.txt")) {
            return lines
                    .map(row -> row.split(" "))
                    .map(row -> new Game(
                            Hand.parse(row[1]),
                            Hand.parse(row[0])
                    ))
                    .toList();
        }
    }

    static List<Game> readFinishStrategy() {
        try (Stream<String> lines = Resources.readLines("/strategy.txt")) {
            return lines
                    .map(row -> row.split(" "))
                    .map(row -> {
                        Hand them = Hand.parse(row[0]);
                        Hand me = them.forResult(Outcome.parse(row[1]));
                        return new Game(me, them);
                    })
                    .toList();
        }
    }

}
