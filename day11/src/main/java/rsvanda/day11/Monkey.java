package rsvanda.day11;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.LongFunction;
import java.util.function.Predicate;

public class Monkey {

    private final LinkedList<Item> items;

    private final Predicate<Long> test;

    private final LongFunction<Long> operation;

    private final Consumer<Item> onTrue;

    private final Consumer<Item> onFalse;

    private final LongFunction<Long> relief;

    private int totalInspects = 0;

    public Monkey(
            List<Item> items,
            Predicate<Long> test,
            LongFunction<Long> operation,
            Consumer<Item> onTrue,
            Consumer<Item> onFalse, LongFunction<Long> relief) {
        this.items = new LinkedList<>(items);
        this.test = test;
        this.operation = operation;
        this.onTrue = onTrue;
        this.onFalse = onFalse;
        this.relief = relief;
    }

    public void addItem(Item item) {
        this.items.addLast(item);
    }

    public void inspectAll() {
        while (!items.isEmpty()) {
            Item item = items.removeFirst();
            item.worryLevel(relief.apply(operation.apply(item.worryLevel())));
            if (test.test(item.worryLevel())) {
                onTrue.accept(item);
            } else {
                onFalse.accept(item);
            }
            totalInspects++;
        }
    }

    public int getTotalInspects() {
        return totalInspects;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

}
