package rsvanda.day02;

public enum Outcome {

    LOOSE(0), DRAW(3), WIN(6);

    private Integer score;

    Outcome(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public static Outcome parse(String value) {
        return switch (value) {
            case "X" -> LOOSE;
            case "Y" -> DRAW;
            case "Z" -> WIN;
            default -> throw new IllegalArgumentException("Unknown value [" + value + "]");
        };
    }

}
