package rsvanda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class InputStreams {

    private InputStreams() {
    }

    public static <T> List<T> streamToList(InputStream stream, Function<String, T> fn) {
        final List<T> list = new ArrayList<>();
        try (var buffer = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                list.add(fn.apply(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return list;
    }

}
