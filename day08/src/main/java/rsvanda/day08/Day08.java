package rsvanda.day08;

public class Day08 {

    public static void main(String[] args) {
        Forest forest = Forest.read(Day08.class.getResourceAsStream("/input.txt"));
        System.out.println("Visible " + forest.getVisible().size());
        System.out.println("Max view " + forest.maxView());
    }

}
