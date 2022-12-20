package rsvanda.day13;

public record NumberItem(int value) implements Item {
    @Override
    public String asString() {
        return String.valueOf(value);
    }

    @Override
    public ListItem asList() {
        return ListItem.of(this);
    }

    @Override
    public int compareTo(Item o) {
        return asList().compareTo(o.asList());
    }
}
