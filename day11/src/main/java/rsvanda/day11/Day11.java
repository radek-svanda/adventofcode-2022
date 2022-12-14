package rsvanda.day11;

import static rsvanda.day11.MonkeyPack.MonkeyBuilder.divisibleBy;

public class Day11 {

    public static void main(String[] args) {
        MonkeyPack pack = new MonkeyPack();

        pack.add(it -> it
                .items(56, 56, 92, 65, 71, 61, 79)
                .operation(old -> old * 7)
                .test(divisibleBy(3))
                .onTrue(3)
                .onFalse(7)
        );
        pack.add(it -> it
                .items(61, 85)
                .operation(old -> old + 5)
                .test(divisibleBy(11))
                .onTrue(6)
                .onFalse(4)
        );

        pack.add(it -> it
                .items(54, 96, 82, 78, 69)
                .operation(old -> old * old)
                .test(divisibleBy(7))
                .onTrue(0)
                .onFalse(7)
        );
        pack.add(it -> it
                .items(57, 59, 65, 95)
                .operation(old -> old + 4)
                .test(divisibleBy(2))
                .onTrue(5)
                .onFalse(1)
        );
        pack.add(it -> it
                .items(62, 67, 80)
                .operation(old -> old * 17)
                .test(divisibleBy(19))
                .onTrue(2)
                .onFalse(6)
        );
        pack.add(it -> it
                .items(91)
                .operation(old -> old + 7)
                .test(divisibleBy(5))
                .onTrue(1)
                .onFalse(4)
        );
        pack.add(it -> it
                .items(79, 83, 64, 52, 77, 56, 63, 92)
                .operation(old -> old + 6)
                .test(divisibleBy(17))
                .onTrue(2)
                .onFalse(0)
        );
        pack.add(it -> it
                .items(50, 97, 76, 96, 80, 56)
                .operation(old -> old + 3)
                .test(divisibleBy(13))
                .onTrue(3)
                .onFalse(5)
        );

        var game = new MonkeyInTheMiddle(pack);
        game.iterateTo(20);

        Dumper.dumpWithItems(pack);

        System.out.println(pack.totalMonkeyBusiness());

    }

    public void addMonkeys(MonkeyPack pack) {
        pack.add(it -> it
                .items(56, 56, 92, 65, 71, 61, 79)
                .operation(old -> old * 7)
                .test(divisibleBy(3))
                .onTrue(3)
                .onFalse(7)
        );
        pack.add(it -> it
                .items(61, 85)
                .operation(old -> old + 5)
                .test(divisibleBy(11))
                .onTrue(6)
                .onFalse(4)
        );

        pack.add(it -> it
                .items(54, 96, 82, 78, 69)
                .operation(old -> old * old)
                .test(divisibleBy(7))
                .onTrue(0)
                .onFalse(7)
        );
        pack.add(it -> it
                .items(57, 59, 65, 95)
                .operation(old -> old + 4)
                .test(divisibleBy(2))
                .onTrue(5)
                .onFalse(1)
        );
        pack.add(it -> it
                .items(62, 67, 80)
                .operation(old -> old * 17)
                .test(divisibleBy(19))
                .onTrue(2)
                .onFalse(6)
        );
        pack.add(it -> it
                .items(91)
                .operation(old -> old + 7)
                .test(divisibleBy(5))
                .onTrue(1)
                .onFalse(4)
        );
        pack.add(it -> it
                .items(79, 83, 64, 52, 77, 56, 63, 92)
                .operation(old -> old + 6)
                .test(divisibleBy(17))
                .onTrue(2)
                .onFalse(0)
        );
        pack.add(it -> it
                .items(50, 97, 76, 96, 80, 56)
                .operation(old -> old + 3)
                .test(divisibleBy(13))
                .onTrue(3)
                .onFalse(5)
        );

    }

}
