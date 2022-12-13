package rsvanda.day10;

import org.junit.jupiter.api.Test;
import rsvanda.Strings;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTest {


    @Test
    void testParser() {
        String source = """
                noop
                addx 3
                addx -5
                """;
        List<Instruction> list = Instruction.parse(Strings.stringToStream(source));
        assertAll(
                () -> assertEquals(Instruction.Noop.class, list.get(0).getClass()),
                () -> assertEquals(Instruction.Addx.class, list.get(1).getClass()),
                () -> assertEquals(3, ((Instruction.Addx) list.get(1)).getValue()),
                () -> assertEquals(-5, ((Instruction.Addx) list.get(2)).getValue())
        );
    }
}