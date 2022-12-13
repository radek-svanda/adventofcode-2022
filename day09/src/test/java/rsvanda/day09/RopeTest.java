package rsvanda.day09;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class RopeTest {

    @Test
    void movingTest() {

        Knot tail = new Knot();
        Rope rope = new Rope(tail);

        String source = """
                R 4
                U 4
                L 3
                D 1
                R 4
                D 1
                L 5
                R 2
                """;

        Path path = Path.read(new ByteArrayInputStream(source.getBytes()));

        path.moves().forEach(rope::move);

        System.out.println(rope.getTail().getVisited().size());

    }

    @Test
    void longTest() {
        Rope rope = Rope.length(9);

        String source = """
                R 4
                U 4
                L 3
                D 1
                R 4
                D 1
                L 5
                R 2
                """;

        Path path = Path.read(new ByteArrayInputStream(source.getBytes()));

        path.moves().forEach(rope::move);

        System.out.println(rope.getTail().getVisited().size());
    }

    @Test
    void evenLonger() {
        Rope rope = Rope.length(9);
        String source = """
                R 5
                U 8
                L 8
                D 3
                R 17
                D 10
                L 25
                U 20
                """;
        Path path = Path.read(new ByteArrayInputStream(source.getBytes()));

        path.moves().forEach(rope::move);

        System.out.println(rope.getTail().getVisited().size());
    }

}