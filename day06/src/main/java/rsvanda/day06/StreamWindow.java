package rsvanda.day06;

import java.util.LinkedList;

public class StreamWindow {

    private final LinkedList<Integer> queue = new LinkedList<>();

    private final int length;
    private int position = 0;

    public StreamWindow(int length) {
        this.length = length;
    }

    public boolean isUnique() {
        return queue.stream().distinct().count() == length;
    }

    public void add(int item) {
        position += 1;
        queue.push(item);
        if (queue.size() > length) {
            queue.removeLast();
        }
    }

    public int position() {
        return position;
    }
}
