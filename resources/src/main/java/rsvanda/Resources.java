package rsvanda;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class Resources {

    private Resources() {
        // noop
    }

    public static Stream<String> readLines(String resourceName) {
        try {
            URI uri = Objects.requireNonNull(Resources.class.getResource(resourceName)).toURI();
            return Files.lines(Path.of(uri));
        } catch (URISyntaxException | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static <R> List<R> mapLines(String resourceName, Function<String, R> mapper) {
        return readLines(resourceName).map(mapper).toList();
    }

}
