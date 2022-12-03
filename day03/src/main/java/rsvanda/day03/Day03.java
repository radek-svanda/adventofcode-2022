package rsvanda.day03;

import rsvanda.Resources;

import java.util.ArrayList;
import java.util.List;

public class Day03 {

    public static void main(String[] args) {
        List<Rucksack> rucksacks = Resources.mapLines("/input.txt", Rucksack::new);
        Integer sum = rucksacks.stream()
                .map(rucksack -> Intersects.intersect(
                        rucksack.getFirstCompartment(),
                        rucksack.getSecondCompartment()
                ))
                .map(Priorities::priorityOf)
                .reduce(Integer::sum)
                .orElseThrow();
        System.out.println("Sum of priorities: " + sum);

        List<Group> groups = rucksacks.stream().reduce(
                new ArrayList<>(),
                (list, rucksack) -> {
                    if (list.isEmpty()) {
                        list.add(new Group());
                    }
                    Group last = list.get(list.size() - 1);
                    if (last.size() >= 3) {
                        list.add(new Group());
                    }
                    list.get(list.size() - 1).add(rucksack);
                    return list;
                },
                ((list, list2) -> {
                    list.addAll(list2);
                    return list;
                })
        );

        System.out.println("Rucksacks: " + rucksacks.size());
        System.out.println("Groups:    " + groups.size());

        Integer groupTotal = groups.stream()
                .map(it -> it.getMembers().stream().map(Rucksack::contents).toList())
                .map(Intersects::intersect)
                .map(Priorities::priorityOf)
                .reduce(Integer::sum)
                .orElseThrow();

        System.out.println("Group total: " + groupTotal);
    }
}
