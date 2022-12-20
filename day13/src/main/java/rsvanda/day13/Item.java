package rsvanda.day13;

abstract sealed class Item
        implements Comparable<Item>
        permits NumberItem, ListItem {

    abstract String asString();

    abstract ListItem asList();

    @Override
    public String toString() {
        return asString();
    }
}
