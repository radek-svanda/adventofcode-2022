package rsvanda;

import java.io.InputStream;
import java.util.List;

public class Grids {

    public static char[][] charGrid(InputStream stream) {
        final List<char[]> chars = InputStreams.streamToList(stream, String::toCharArray);
        final char[][] res = new char[chars.size()][];
        for (int i = 0; i < chars.size(); i++) {
            res[i] = chars.get(i);
        }
        return res;
    }

}
