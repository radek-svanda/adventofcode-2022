package rsvanda.day05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Stacks {

    private final List<LinkedList<Crate>> stacksInternal = new ArrayList<>();

    private Stacks() {
    }

    public void move(Integer count, Integer from, Integer to) {
        for (int i = 0; i < count; i++) {
            stacksInternal.get(to - 1).addFirst(
                    stacksInternal.get(from - 1).removeFirst()
            );
        }
    }

    public void moveMultiple(Integer count, Integer from, Integer to) {
        List<Crate> crates = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            crates.add(stacksInternal.get(from - 1).removeFirst());
        }
        for (int i = crates.size() - 1; i >= 0; i--) {
            stacksInternal.get(to - 1).addFirst(crates.get(i));
        }
    }

    public static Stacks parse(String source) {
        StacksParser parser = new StacksParser(source);
        Stacks stacks = new Stacks();
        var x = parser.stream()
                .filter(it -> it.get(0) != '1')
                .toList();

        for (int i = x.size() - 1; i >= 0; i--) {
            for (int j = 0; j < x.get(i).size(); j++) {
                char value = x.get(i).get(j);
                if (value != ' ') {
                    stacks.put(j, new Crate(value));
                }
            }
        }

        return stacks;
    }

    private void put(Integer stack, Crate value) {
        for (int i = stacksInternal.size(); i <= stack; i++) {
            stacksInternal.add(new LinkedList<>());
        }
        stacksInternal.get(stack).addFirst(value);
    }

    public List<Crate> getTopCrates() {
        return stacksInternal.stream()
                .map(LinkedList::getFirst)
                .toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stacks{\n");
        String collect = stacksInternal.stream()
                .map(row ->
                        row.stream()
                                .map(Crate::stringValue)
                                .collect(Collectors.joining(" "))
                )
                .collect(Collectors.joining("\n"));
        sb.append(collect).append("\n}");
        return sb.toString();
    }
}
