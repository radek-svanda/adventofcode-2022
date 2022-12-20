package rsvanda.day13;

import org.junit.jupiter.api.Test;
import rsvanda.Resources;

import java.util.List;

class Task2Test {

    @Test
    void example() {
        List<ListItem> items = Resources.readLines("/example.txt")
                .filter(s -> !s.isBlank())
                .map(ListItem::read)
                .toList();

        Task2 task2 = new Task2(items);
        System.out.println(task2.solve());
    }

}