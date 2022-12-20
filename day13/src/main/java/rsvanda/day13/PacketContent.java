package rsvanda.day13;

import java.util.*;

public class PacketContent implements Comparable<PacketContent> {

    private final ListItem items;

    public PacketContent(ListItem items) {
        this.items = items;
    }

    public ListItem getItems() {
        return items;
    }

    @Override
    public int compareTo(PacketContent o) {
        return 0;
    }

    public static PacketContent read(String source) {

        LinkedList<ListItem> queue = new LinkedList<>();

        ListItem root = null;

        for (int c : source.chars().toArray()) {
            switch (c) {
                case '[' -> {
                    ListItem list = new ListItem();
                    if (root == null) {
                        root = list;
                    } else {
                        queue.getLast().add(list);
                    }
                    queue.addLast(list);
                }
                case ']' -> queue.removeLast();
                case ',' -> {
                    // noop
                }
                default -> {
                    queue.getLast().add(new NumberItem(c - '0'));
                }
            }
        }


        return new PacketContent(root);

    }

}
