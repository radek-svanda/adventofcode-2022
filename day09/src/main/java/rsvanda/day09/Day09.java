package rsvanda.day09;

public class Day09 {


    public static void main(String[] args) {
        Path path = Path.read(Day09.class.getResourceAsStream("/input.txt"));
        Knot tail = new Knot();
        Rope rope = new Rope(tail);

        path.moves().forEach(rope::move);

        // 6406
        System.out.println(tail.getVisited().size());

        Rope longer = Rope.length(9);
        path.moves().forEach(longer::move);
        // 2643
        System.out.println(longer.getTail().getVisited().size());
    }

}
