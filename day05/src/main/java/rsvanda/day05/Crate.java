package rsvanda.day05;

public class Crate {

    private final char value;

    public Crate(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Crate{" +
                "value=" + value +
                '}';
    }

    public String stringValue() {
        return String.valueOf(value);
    }
}
