package rsvanda.day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void forResult() {
        assertEquals(Hand.PAPER, Hand.ROCK.forResult(Outcome.WIN));
        assertEquals(Hand.ROCK, Hand.ROCK.forResult(Outcome.DRAW));
        assertEquals(Hand.SCISSORS, Hand.ROCK.forResult(Outcome.LOOSE));
    }

}