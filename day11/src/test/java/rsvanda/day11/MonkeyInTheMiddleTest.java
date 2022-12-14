package rsvanda.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static rsvanda.day11.Dumper.dumpWithInspections;
import static rsvanda.day11.Dumper.dumpWithItems;
import static rsvanda.day11.MonkeyPack.MonkeyBuilder.times;

class MonkeyInTheMiddleTest {

    void addMonkeys(MonkeyPack pack) {

        pack.add(it -> it
                .items(79, 98)
                .operation(times(19))
                .divisibleBy(23)
                .onTrue(2)
                .onFalse(3)
        );
        pack.add(it -> it
                .items(54, 65, 75, 74)
                .operation(old -> old + 6)
                .divisibleBy(19)
                .onTrue(2)
                .onFalse(0)
        );
        pack.add(it -> it
                .items(79, 60, 97)
                .operation(old -> old * old)
                .divisibleBy(13)
                .onTrue(1)
                .onFalse(3)
        );
        pack.add(it -> it
                .items(74)
                .operation(old -> old + 3)
                .divisibleBy(17)
                .onTrue(0)
                .onFalse(1)
        );

        dumpWithItems(pack);

    }

    @Test
    void initialTest() {

        MonkeyPack pack = new MonkeyPack();
        addMonkeys(pack);

        var game = new MonkeyInTheMiddle(pack,
                pack.worryReducer().andThen(MonkeyInTheMiddle.INITIAL_RELIEF)
        );

        game.iterate();

        dumpWithItems(pack);

        game.iterate();
        dumpWithItems(pack);

        game.iterateTo(9);
        dumpWithItems(pack);
        game.iterateTo(15);
        dumpWithItems(pack);
        game.iterateTo(20);
        dumpWithItems(pack);

        Assertions.assertEquals(10605, pack.totalMonkeyBusiness());
    }

    @Test
    void longTest() {

        MonkeyPack pack = new MonkeyPack();
        addMonkeys(pack);

        var game = new MonkeyInTheMiddle(pack, pack.worryReducer());

        game.iterate();

        dumpWithInspections(pack);

        game.iterateTo(1000);
        dumpWithInspections(pack);

        game.iterateTo(10000);
        dumpWithInspections(pack);

        Assertions.assertEquals(2713310158L, pack.totalMonkeyBusiness());
    }


}