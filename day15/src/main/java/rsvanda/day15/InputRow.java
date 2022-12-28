package rsvanda.day15;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public record InputRow(Sensor sensor, Beacon beacon) {

    private static final Pattern pattern =
            compile("Sensor at x=([0-9\\-]+), y=([0-9\\-]+): closest beacon is at x=([0-9\\-]+), y=([0-9\\-]+)");

    public static InputRow parse(String row) {
        var m = pattern.matcher(row);
        if (!m.matches()) {
            throw new IllegalArgumentException("Invalid input line " + row);
        }
        return new InputRow(
                new Sensor(
                        Integer.parseInt(m.group(1)),
                        Integer.parseInt(m.group(2))
                ),
                new Beacon(
                        Integer.parseInt(m.group(3)),
                        Integer.parseInt(m.group(4))
                )
        );
    }
}
