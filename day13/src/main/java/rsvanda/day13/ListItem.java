package rsvanda.day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class ListItem extends Item {

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
                int compare = items.get(i).compareTo(other.items.get(i));
                if (compare != 0) {
                    return compare;
                }
            }
            return items.size() - other.items.size();
        } else {
            return compareTo(o.asList());
        }
    }

    public static ListItem of(Item item) {
        ListItem list = new ListItem();
        list.add(item);
        return list;
    }

    public static ListItem read(String source) {

        LinkedList<ListItem> queue = new LinkedList<>();

        ListItem root = null;
        StringBuilder builder = new StringBuilder();

        Consumer<StringBuilder> append = value -> {
            int length = builder.length();
            if (length > 0) {
                NumberItem item = new NumberItem(Integer.valueOf(builder.toString()));
                queue.getLast().add(item);
                builder.delete(0, length);
            }
        };

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
                case ']' -> {
                    append.accept(builder);
                    queue.removeLast();
                }
                case ',' -> {
                    append.accept(builder);
                }
                default -> {
                    builder.append((char) c);
                }
            }
        }

        return root;

    }

}
