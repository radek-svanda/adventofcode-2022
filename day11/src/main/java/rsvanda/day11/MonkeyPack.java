package rsvanda.day11;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.LongFunction;
import java.util.function.Predicate;

public class MonkeyPack implements Iterable<Monkey> {

    private final List<Monkey> monkeys = new ArrayList<>();

    private LongFunction<Long> relief = (value -> value / 3);

    public void add(Monkey monkey) {
        this.monkeys.add(monkey);
    }

    public void add(Consumer<MonkeyBuilder> consumer) {
        MonkeyBuilder monkeyBuilder = new MonkeyBuilder();
        consumer.accept(monkeyBuilder);
        monkeys.add(monkeyBuilder.build());
    }

    public List<Monkey> getMonkeys() {
        return Collections.unmodifiableList(monkeys);
    }

    public Consumer<Item> throwItem(int monkey) {
        return item -> monkeys.get(monkey).addItem(item);
    }

    @Override
    public Iterator<Monkey> iterator() {
        return monkeys.iterator();
    }

    public long totalMonkeyBusiness() {
        return monkeys.stream()
                .mapToInt(Monkey::getTotalInspects)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(2)
                .mapToLong(Integer::longValue)
                .reduce((a, b) -> a * b)
                .orElseThrow();
    }

    public void setRelief(LongFunction<Long> relief) {
        this.relief = relief;
    }

    public class MonkeyBuilder {

        private List<Item> items;

        private Predicate<Long> test;

        private LongFunction<Long> operation;

        private Consumer<Item> onTrue;

        private Consumer<Item> onFalse;

        public MonkeyBuilder items(Integer... levels) {
            this.items = Arrays.stream(levels)
                    .map(Item::new)
                    .toList();
            return this;
        }

        public MonkeyBuilder test(Predicate<Long> test) {
            this.test = test;
            return this;
        }

        public MonkeyBuilder operation(LongFunction<Long> operation) {
            this.operation = operation;
            return this;
        }

        public MonkeyBuilder onTrue(int monkey) {
            this.onTrue = throwItem(monkey);
            return this;
        }

        public MonkeyBuilder onFalse(int monkey) {
            this.onFalse = throwItem(monkey);
            return this;
        }

        public Monkey build() {
            return new Monkey(items, test, operation, onTrue, onFalse, relief);
        }

        public static Predicate<Long> divisibleBy(int by) {
            return value -> (value % by) == 0;
        }

        public static LongFunction<Long> times(int value) {
            return it -> value * it;
        }

    }
}
