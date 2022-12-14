package rsvanda.day10;

import java.util.List;
import java.util.stream.IntStream;

public class Clock {

    private int current = 0;

    private final List<Timed> devices;

    public Clock(List<Timed> devices) {
        this.devices = devices;
    }

    public void tick(int count) {
        IntStream.range(0, count).forEach(i -> devices.forEach(Timed::tick));
        current += count;
    }

    public void tickTo(int value) {
        tick(value - current);
    }

}
