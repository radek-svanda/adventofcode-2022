package rsvanda.day09;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class HeadTest {

    @Test
    void movingTest() {

        Tail tail = new Tail();
        Head head = new Head(tail);

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

        path.moves().forEach(head::move);

        System.out.println(tail.getVisited().size());

    }

}