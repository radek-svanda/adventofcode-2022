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

    public Cell moveTo(Cell other) {
        if (this.borders(other)) {
            return this;
        } else {
            if (Math.abs(other.x - x) > 1) {
                return cell(other.x > x ? other.x - 1 : other.x + 1, other.y);
            } else if (Math.abs(other.y - y) > 1) {
                return cell(other.x, other.y > y ? other.y - 1 : other.y + 1);
            }
            throw new IllegalStateException();
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
