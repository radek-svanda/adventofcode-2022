package rsvanda.day13;

public record ItemPair(Item left, Item right) {

    public boolean correctOrder() {
        return left.compareTo(right) < 0;
    }
}
