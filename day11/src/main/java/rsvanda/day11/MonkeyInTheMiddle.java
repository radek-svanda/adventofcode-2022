package rsvanda.day11;

import java.util.function.LongUnaryOperator;

public class MonkeyInTheMiddle {

    private final MonkeyPack pack;

    private int iterations = 0;

    private final LongUnaryOperator worryReduce;

    public static final LongUnaryOperator INITIAL_RELIEF = (value -> value / 3);

    public MonkeyInTheMiddle(MonkeyPack pack, LongUnaryOperator worryReduce) {
        this.pack = pack;
        this.worryReduce = worryReduce;
    }

    public void iterate() {
        pack.getMonkeys().forEach(monkey -> monkey.inspectAll(worryReduce));
        iterations++;
    }

    public void iterateTo(int cnt) {
        while (iterations < cnt) {
            iterate();
        }
    }

}
