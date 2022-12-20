package rsvanda.day13;

import org.junit.jupiter.api.Test;
import rsvanda.Resources;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void example() {
        Task1 task = read("/example.txt");
        assertEquals(13, task.getScore());
    }

    @Test
    void input2() {
        Task1 task = read("/input2.txt");
        assertEquals(5292, task.getScore());
    }

    @Test
    void input2debug() {
        Task1 task = read("/input2.txt");

        List<Boolean> expected = Resources.readLines("/expected2.txt")
                .map(Boolean::valueOf)
                .toList();

        for (int i = 0; i < task.getPairs().size(); i++) {
            ItemPair pair = task.getPairs().get(i);
            if (expected.get(i) != pair.correctOrder()) {
                System.out.println(i);
                System.out.println(expected.get(i));
                System.out.println(pair.left() + "\n" + pair.right() + "\n");
            }
        }
    }

    private Task1 read(String file) {
        List<String> list = Resources.readLines(file).toList();
        List<ItemPair> pairs = new ArrayList<>();

        for (int i = 0; i < list.size(); i += 3) {
            ListItem left = ListItem.read(list.get(i));
            ListItem right = ListItem.read(list.get(i + 1));
            ItemPair pair = new ItemPair(left, right);
            pairs.add(pair);
        }

        return new Task1(pairs);
    }

}