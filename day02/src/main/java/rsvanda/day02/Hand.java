package rsvanda.day02;

import java.util.Arrays;

public enum Hand {

    ROCK(1, "SCISSORS"), PAPER(2, "ROCK"), SCISSORS(3, "PAPER");

    private Integer score;

    private String beats;

    private Hand(Integer score, String beats) {
        this.score = score;
        this.beats = beats;
    }

    public static Hand parse(String value) {
        return switch (value) {
            case "A", "X" -> ROCK;
            case "B", "Y" -> PAPER;
            case "C", "Z" -> SCISSORS;
            default -> throw new IllegalArgumentException("Unknown value [" + value + "]");
        };
    }

    public Integer getScore() {
        return score;
    }

    public Outcome challenge(Hand other) {
        if (this == other) {
            return Outcome.DRAW;
        } else if (valueOf(this.beats) == other) {
            return Outcome.WIN;
        } else {
            return Outcome.LOOSE;
        }
    }

    public Hand forResult(Outcome outcome) {
        if (outcome == Outcome.DRAW) {
            return this;
        } else if (outcome == Outcome.LOOSE) {
            return Hand.valueOf(this.beats);
        } else {
            return Arrays.stream(Hand.values())
                    .filter(it -> it.challenge(this) == Outcome.WIN)
                    .findFirst()
                    .orElseThrow();
        }
    }

}
