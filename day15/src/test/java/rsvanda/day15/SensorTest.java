package rsvanda.day15;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {

    @Test
    void covers() {
        Sensor sensor = new Sensor(8, 7);
        Beacon beacon = new Beacon(2, 10);
        sensor.beacon(beacon);

        assertTrue(sensor.covers(8, -2));
        assertTrue(sensor.covers(8, 16));
        assertTrue(sensor.covers(-1, 7));
        assertTrue(sensor.covers(17, 7));

        assertFalse(sensor.covers(-2, 7));
        assertFalse(sensor.covers(18, 7));
    }

    @Test
    void anotherCover() {
        Sensor sensor = new Sensor(20, 14);
        Beacon beacon = new Beacon(25, 17);
        sensor.beacon(beacon);

        assertFalse(sensor.covers(25, 10));
        assertTrue(sensor.covers(24, 10));
    }

    @Test
    void streamTest() {
        Stream<Long> range = Stream.concat(
                LongStream.range(3, 5).boxed(),
                LongStream.range(7, 11).boxed()
        ).sorted().distinct();

        range.forEach(System.out::println);
    }

}