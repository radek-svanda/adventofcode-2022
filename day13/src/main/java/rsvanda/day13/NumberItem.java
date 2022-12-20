package rsvanda.day13;

public final class NumberItem extends Item {

    private final int value;

    public NumberItem(int value) {
        this.value = value;
    }

    @Override
    public String asString() {
        return String.valueOf(this.value);
    }

    @Override
    public ListItem asList() {
        return ListItem.of(this);
    }

    @Override
    public int compareTo(Item o) {
        if (o instanceof ListItem other) {
            return asList().compareTo(other);
        } else {
            return value - ((NumberItem) o).value;
        }
    }
}
