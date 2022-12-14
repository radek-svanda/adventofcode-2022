package rsvanda.day10;

public class Sprite {

    private int from = 0;
    private int to = 2;

    public boolean isVisibleAt(int x) {
        return from <= x && x <= to;
    }

    public void moveTo(int pos) {
        from = pos - 1;
        to = pos + 1;
    }

}
