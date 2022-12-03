package rsvanda.day03;

public record Rucksack(String contents) {

    public String getFirstCompartment() {
        return contents.substring(0, contents.length() / 2);
    }

    public String getSecondCompartment() {
        return contents.substring(contents.length() / 2);
    }

}
