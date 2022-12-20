package rsvanda.day13;

public interface Item extends Comparable<Item> {

    String asString();

    ListItem asList();

}
