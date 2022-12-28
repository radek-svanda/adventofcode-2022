package rsvanda.day15;

public class Day15 {

    public static class Part1 {

        public long solve() {
            BeaconDetector detector = BeaconDetector.from(Day15.class.getResourceAsStream("/input.txt"));
            return detector.coveredOnRow(2000000L);
        }

    }

}
