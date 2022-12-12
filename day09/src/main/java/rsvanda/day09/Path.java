package rsvanda.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public record Path(List<Move> moves) {

    public static Path read(InputStream stream) {
        List<Move> moves = new ArrayList<>();
        try (var buffer = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] chunks = line.split(" ");
                moves.add(new Move(Direction.valueOf(chunks[0]), Integer.parseInt(chunks[1])));
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return new Path(moves);
    }
}
