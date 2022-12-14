package rsvanda.day11;

public class Day11 {

    public static void main(String[] args) {

        initialRound();
        secondRound();

    }

    static void initialRound() {
        MonkeyPack pack = new MonkeyPack();
        addMonkeys(pack);

        var game = new MonkeyInTheMiddle(pack, MonkeyInTheMiddle.INITIAL_RELIEF);

        game.iterateTo(20);
        Dumper.dumpWithItems(pack);

        // 67830
        System.out.println(pack.totalMonkeyBusiness());
    }

    static void secondRound() {
        MonkeyPack pack = new MonkeyPack();
        addMonkeys(pack);

        var game = new MonkeyInTheMiddle(pack, pack.worryReducer());

        game.iterateTo(10000);
        Dumper.dumpWithItems(pack);

        // 15305381442
        System.out.println(pack.totalMonkeyBusiness());
    }

    static void addMonkeys(MonkeyPack pack) {
        pack.add(it -> it
                .items(56, 56, 92, 65, 71, 61, 79)
                .operation(old -> old * 7)
                .divisibleBy(3)
                .onTrue(3)
                .onFalse(7)
        );
        pack.add(it -> it
                .items(61, 85)
                .operation(old -> old + 5)
                .divisibleBy(11)
                .onTrue(6)
                .onFalse(4)
        );

        pack.add(it -> it
                .items(54, 96, 82, 78, 69)
                .operation(old -> old * old)
                .divisibleBy(7)
                .onTrue(0)
                .onFalse(7)
        );
        pack.add(it -> it
                .items(57, 59, 65, 95)
                .operation(old -> old + 4)
                .divisibleBy(2)
                .onTrue(5)
                .onFalse(1)
        );
        pack.add(it -> it
                .items(62, 67, 80)
                .operation(old -> old * 17)
                .divisibleBy(19)
                .onTrue(2)
                .onFalse(6)
        );
        pack.add(it -> it
                .items(91)
                .operation(old -> old + 7)
                .divisibleBy(5)
                .onTrue(1)
                .onFalse(4)
        );
        pack.add(it -> it
                .items(79, 83, 64, 52, 77, 56, 63, 92)
                .operation(old -> old + 6)
                .divisibleBy(17)
                .onTrue(2)
                .onFalse(0)
        );
        pack.add(it -> it
                .items(50, 97, 76, 96, 80, 56)
                .operation(old -> old + 3)
                .divisibleBy(13)
                .onTrue(3)
                .onFalse(5)
        );

    }

}
