package rsvanda.day06;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MessageStreamUtilTest {

    @Test
    void packetTest() {
        assertAll(
                () -> assertPacketPosition(7, "mjqjpqmgbljsphdztnvjfqwrcgsmlb"),
                () -> assertPacketPosition(5, "bvwbjplbgvbhsrlpgdmjqwftvncz"),
                () -> assertPacketPosition(6, "nppdvjthqldpwncqszvftbrmjlhg"),
                () -> assertPacketPosition(10, "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"),
                () -> assertPacketPosition(11, "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")
        );
    }

    @Test
    void messageTest() {
        assertAll(
                () -> assertMessagePosition(19, "mjqjpqmgbljsphdztnvjfqwrcgsmlb"),
                () -> assertMessagePosition(23, "bvwbjplbgvbhsrlpgdmjqwftvncz"),
                () -> assertMessagePosition(23, "nppdvjthqldpwncqszvftbrmjlhg"),
                () -> assertMessagePosition(29, "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"),
                () -> assertMessagePosition(26, "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")
        );
    }

    private void assertPacketPosition(int expected, String source) {
        InputStream stream = new ByteArrayInputStream(source.getBytes());
        assertEquals(expected, MessageStreamUtil.packetStartPosition(stream));
    }

    private void assertMessagePosition(int expected, String source) {
        InputStream stream = new ByteArrayInputStream(source.getBytes());
        assertEquals(expected, MessageStreamUtil.messageStartPosition(stream));
    }

}