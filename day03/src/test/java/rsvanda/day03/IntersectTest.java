package rsvanda.day03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntersectTest {

    @Test
    void intersectTEst() {
        assertEquals('p',
                Intersects.intersect(
                        "vJrwpWtwJgWr", "hcsFMMfFFhFp"
                ));
        assertEquals('p',
                Intersects.intersect(
                        Arrays.asList("vJrwpWtwJgWr", "hcsFMMfFFhFp")
                ));
    }

}