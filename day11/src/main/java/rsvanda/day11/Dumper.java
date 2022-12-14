package rsvanda.day11;

public class Dumper {

    private Dumper() {
    }

    public static void dumpWithItems(MonkeyPack pack) {

        for (int i = 0; i < pack.getMonkeys().size(); i++) {
            System.out.println("Monkey" + i + ": " +
                    pack.getMonkeys().get(i).getItems()
                            .stream()
                            .map(Item::worryLevel)
                            .toList());
        }
        System.out.println();

    }

    public static void dumpWithInspections(MonkeyPack pack) {
        for (int i = 0; i < pack.getMonkeys().size(); i++) {
            System.out.println("Monkey" + i + ": " +
                    pack.getMonkeys().get(i).getTotalInspects());
        }
        System.out.println();
    }

}
