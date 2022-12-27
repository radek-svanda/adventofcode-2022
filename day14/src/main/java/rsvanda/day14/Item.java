package rsvanda.day14;

public enum Item {

    AIR('.'), ROCK('#'), SAND('o');

    private final char sign;

    Item(char sign) {
        this.sign = sign;
    }

    public boolean blocking() {
        return this == ROCK || this == SAND;
    }

    public boolean free() {
        return !blocking();
    }

    public char sign() {
        return sign;
    }
}
