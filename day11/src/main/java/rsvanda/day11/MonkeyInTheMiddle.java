package rsvanda.day11;

public class MonkeyInTheMiddle {

    private final MonkeyPack pack;

    private int iterations = 0;

    public MonkeyInTheMiddle(MonkeyPack pack) {
        this.pack = pack;
    }

    public void iterate() {
        pack.getMonkeys().forEach(Monkey::inspectAll);
        iterations++;
    }

    public void iterateTo(int cnt) {
        while (iterations < cnt) {
            iterate();
        }
    }

}
