package rsvanda.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class ListItem implements Item {

    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public String asString() {
        return "[" + items.stream().map(Item::asString).collect(Collectors.joining(",")) + "]";
    }

    @Override
    public ListItem asList() {
        return this;
    }

    @Override
    public int compareTo(Item o) {
        if (o instanceof ListItem other) {
            for (int i = 0; i < items.size() && i < other.items.size(); i++) {

            }
            return -1;
        } else {
            throw new IllegalArgumentException("Incomparable with " + o);
        }
    }

    public static ListItem of(Item item) {
        ListItem list = new ListItem();
        list.add(item);
        return list;
    }
}
