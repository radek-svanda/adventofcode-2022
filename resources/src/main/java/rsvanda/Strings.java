package rsvanda;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Strings {

    private Strings() {
    }

    public static InputStream stringToStream(String value) {
        return new ByteArrayInputStream(value.getBytes());
    }

}
