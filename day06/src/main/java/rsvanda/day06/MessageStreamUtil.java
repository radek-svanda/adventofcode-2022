package rsvanda.day06;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageStreamUtil {

    private MessageStreamUtil() {
    }

    public static int packetStartPosition(InputStream stream) {
        try (InputStreamReader reader = new InputStreamReader(stream)) {
            return findMarker(reader, 4);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int messageStartPosition(InputStream stream) {
        try (InputStreamReader reader = new InputStreamReader(stream)) {
            return findMarker(reader, 14);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int findMarker(InputStreamReader reader, int length) throws IOException {
        var window = new StreamWindow(length);
        int c;
        while ((c = reader.read()) != -1) {
            window.add(c);
            if (window.isUnique()) {
                return window.position();
            }
        }
        return -1;
    }

}
