package rsvanda.day05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StacksParser implements Iterable<List<Character>> {

    private final String source;

    public StacksParser(String source) {
        this.source = source;
    }

    @Override
    public Iterator<List<Character>> iterator() {
        return new StackIterator(source);
    }

    public Stream<List<Character>> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    private static class StackIterator implements Iterator<List<Character>> {

        private final String[] lines;
        private int current = 0;

        private StackIterator(String source) {
            this.lines = source.split("\n");
        }

        @Override
        public boolean hasNext() {
            return current < lines.length;
        }

        @Override
        public List<Character> next() {
            if (current >= lines.length) {
                throw new NoSuchElementException();
            }
            String line = lines[current++];
            List<Character> chars = new ArrayList<>();
            int step = 0;
            int pos = 0;
            while (step < 4 && pos < line.length()) {
                if (step == 1) {
                    chars.add(line.charAt(pos));
                }
                step = (step == 3 ? 0 : step + 1);
                pos++;
            }
            return chars;
        }
    }

}
