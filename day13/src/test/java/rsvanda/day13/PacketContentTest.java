package rsvanda.day13;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PacketContentTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "[1,1,3,1,1]",
            "[[1],[2,3,4]]",
            "[[[]]]",
            "[1,[2,[3,[4,[5,6,7]]]],8,9]"
    })
    void parser(String source) {
        assertEquals(source, PacketContent.read(source).getItems().asString());
    }



}