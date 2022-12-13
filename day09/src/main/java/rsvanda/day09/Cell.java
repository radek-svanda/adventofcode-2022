package rsvanda.day09;

import java.util.stream.IntStream;

public record Cell(int x, int y) {

    public static final Cell start = cell(0, 0);

    Cell move(Direction direction) {
        return switch (direction) {
            case D -> cell(x, y - 1);
            case L -> cell(x - 1, y);
            case R -> cell(x + 1, y);
            case U -> cell(x, y + 1);
        };
    }

    private int middle(int a, int b) {
        return (int) Math.ceil((double) (a + b) / 2);
    }


    public Cell moveTo(Cell other) {
        if (this.borders(other)) {
            return this;
        } else {
            return cell(middle(other.x, x), middle(other.y, y));
        }
    }

    public boolean borders(Cell other) {
        return IntStream.range(x - 1, x + 2).anyMatch(it -> it == other.x)
                && IntStream.range(y - 1, y + 2).anyMatch(it -> it == other.y);
    }

    public static Cell cell(int x, int y) {
        return new Cell(x, y);
    }
}
