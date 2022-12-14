package rsvanda.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static rsvanda.day11.Dumper.dumpWithInspections;
import static rsvanda.day11.Dumper.dumpWithItems;
import static rsvanda.day11.MonkeyPack.MonkeyBuilder.divisibleBy;
import static rsvanda.day11.MonkeyPack.MonkeyBuilder.times;

class MonkeyInTheMiddleTest {

    void addMonkeys(MonkeyPack pack) {

        pack.add(it -> it
                .items(79, 98)
                .operation(times(19))
                .test(divisibleBy(23))
                .onTrue(2)
                .onFalse(3)
        );
        pack.add(it -> it
                .items(54, 65, 75, 74)
                .operation(old -> old + 6)
                .test(divisibleBy(19))
                .onTrue(2)
                .onFalse(0)
        );
        pack.add(it -> it
                .items(79, 60, 97)
                .operation(old -> old * old)
                .test(divisibleBy(13))
                .onTrue(1)
                .onFalse(3)
        );
        pack.add(it -> it
                .items(74)
                .operation(old -> old + 3)
                .test(divisibleBy(17))
                .onTrue(0)
                .onFalse(1)
        );

        dumpWithItems(pack);

    }

    @Test
    void initialTest() {

        MonkeyPack pack = new MonkeyPack();
        addMonkeys(pack);

        var game = new MonkeyInTheMiddle(pack);
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
        pack.setRelief(value -> value);
        addMonkeys(pack);

        var game = new MonkeyInTheMiddle(pack);
        game.iterate();

        dumpWithInspections(pack);

        game.iterateTo(1000);
        dumpWithInspections(pack);

//        game.iterateTo(10000);
//        dumpWithInspections(pack);

//        game.iterate();
//        dump(pack);
//
//        game.iterateTo(9);
//        dump(pack);
//        game.iterateTo(15);
//        dump(pack);
//        game.iterateTo(20);
//        dump(pack);

//        Assertions.assertEquals(2713310158L, pack.totalMonkeyBusiness());
    }


}