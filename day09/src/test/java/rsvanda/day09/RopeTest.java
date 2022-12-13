package rsvanda.day09;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        path.moves().forEach(move -> {

            rope.move(move);
            System.out.println(rope.getPosition());
            System.out.println(rope.getTail().getVisited().size());
            TailDump.dump(rope.getTail());

            System.out.println();

        });

        assertEquals(13, rope.getTail().getVisited().size());

        TailDump.dump(rope.getTail());

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

        assertEquals(1, rope.getTail().getVisited().size());

        TailDump.dump(rope.getTail());
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

        assertEquals(36, rope.getTail().getVisited().size());

        TailDump.dump(rope.getTail());

    }

}