package rsvanda.day11;

public final class Item {
    private long worryLevel;

    public Item(long worryLevel) {
        this.worryLevel = worryLevel;
    }

    public long worryLevel() {
        return worryLevel;
    }

    public void worryLevel(long value) {
        if (value < 0) {
            throw new IllegalStateException("Overflow!!");
        }
        this.worryLevel = value;
    }

}
