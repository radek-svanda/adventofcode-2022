package rsvanda;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

public class Resources {

    public static Stream<String> readLines(String resourceName) {
        try {
            URI uri = Objects.requireNonNull(Resources.class.getResource(resourceName)).toURI();
            return Files.lines(Path.of(uri));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
