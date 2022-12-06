package rsvanda.day06;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.function.ToIntFunction;

public class Day06 {

    public static void main(String[] args) {
        printPosition((MessageStreamUtil::packetStartPosition));
        printPosition((MessageStreamUtil::messageStartPosition));
    }

    private static void printPosition(ToIntFunction<InputStream> fn) {
        try (InputStream stream = Objects.requireNonNull(Day06.class.getResourceAsStream("/input.txt"))) {
            System.out.println(fn.applyAsInt(stream));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
