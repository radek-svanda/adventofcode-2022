package rsvanda.day13;

import rsvanda.Resources;

import java.util.ArrayList;
import java.util.List;

public class Day13 {

    public static void main(String[] args) {
        List<String> list = Resources.readLines("/input.txt").toList();
        List<ItemPair> pairs = new ArrayList<>();
        List<ListItem> items = new ArrayList<>();

        for (int i = 0; i < list.size(); i += 3) {
            ListItem left = ListItem.read(list.get(i));
            ListItem right = ListItem.read(list.get(i + 1));
            ItemPair pair = new ItemPair(left, right);
            pairs.add(pair);
            items.add(left);
            items.add(right);
        }

        // 6187
        System.out.println(new Task1(pairs).getScore());
        // 23520
        System.out.println(new Task2(items).solve());

    }
}
