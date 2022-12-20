package rsvanda.day13;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private final List<ListItem> items;

    public Task2(List<ListItem> items) {
        this.items = new ArrayList<>(items);
    }

    public int solve() {
        ListItem item6 = ListItem.read("[[6]]");
        ListItem item2 = ListItem.read("[[2]]");
        items.add(item6);
        items.add(item2);
        List<ListItem> sorted = items.stream().sorted().toList();
        int pos2 = sorted.indexOf(item2) + 1;
        int pos6 = sorted.indexOf(item6) + 1;

        return pos2 * pos6;
    }
}
