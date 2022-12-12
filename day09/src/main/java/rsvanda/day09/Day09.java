package rsvanda.day09;

public class Day09 {


    public static void main(String[] args) {
        Path path = Path.read(Day09.class.getResourceAsStream("/input.txt"));
        Tail tail = new Tail();
        Head head = new Head(tail);

        path.moves().forEach(head::move);

        System.out.println(tail.getVisited().size());
    }

}
