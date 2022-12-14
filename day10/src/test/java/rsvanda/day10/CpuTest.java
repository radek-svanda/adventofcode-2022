package rsvanda.day10;

import org.junit.jupiter.api.Test;
import rsvanda.Strings;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CpuTest {

    @Test
    void shortExecution() {
        String source = """
                noop
                addx 3
                addx -5
                """;
        List<Instruction> list = Instruction.parse(Strings.stringToStream(source));
        Cpu cpu = new Cpu(list);
        Clock clock = new Clock(List.of(cpu));

        clock.tick(1);
        assertEquals(Instruction.Noop.class, cpu.current().getClass());
        assertTrue(cpu.current().finished());
        assertEquals(1, cpu.x());

        clock.tick(1);
        assertEquals(Instruction.Addx.class, cpu.current().getClass());
        assertFalse(cpu.current().finished());
        assertEquals(1, cpu.x());

        clock.tick(1);
        assertEquals(Instruction.Addx.class, cpu.current().getClass());
        assertTrue(cpu.current().finished());
        assertEquals(1, cpu.x());

        clock.tick(1);
        assertEquals(Instruction.Addx.class, cpu.current().getClass());
        assertFalse(cpu.current().finished());
        assertEquals(4, cpu.x());

        clock.tick(1);
        assertEquals(Instruction.Addx.class, cpu.current().getClass());
        assertTrue(cpu.current().finished());
        assertEquals(4, cpu.x());

        assertEquals(5, cpu.cycles());
    }
    @Test
    void longExecution() {
        List<Instruction> instructions = Instruction.parse(Strings.stringToStream(source));
        Cpu cpu = new Cpu(instructions);
        Clock clock = new Clock(List.of(cpu));

        clock.tick(20);
        assertEquals(20, cpu.cycles());
        assertEquals(21, cpu.x());
        assertEquals(420, cpu.signal());

        clock.tick(40);
        assertEquals(60, cpu.cycles());
        assertEquals(19, cpu.x());
        assertEquals(1140, cpu.signal());

        clock.tick(40);
        assertEquals(100, cpu.cycles());
        assertEquals(18, cpu.x());
        assertEquals(1800, cpu.signal());

        clock.tick(40);
        assertEquals(140, cpu.cycles());
        assertEquals(21, cpu.x());
        assertEquals(2940, cpu.signal());

        clock.tick(40);
        assertEquals(180, cpu.cycles());
        assertEquals(16, cpu.x());
        assertEquals(16 * 180, cpu.signal());

        clock.tick(40);
        assertEquals(220, cpu.cycles());
        assertEquals(18, cpu.x());
        assertEquals(3960, cpu.signal());

    }

    @Test
    void executeTo() {
        List<Instruction> instructions = Instruction.parse(Strings.stringToStream(source));
        Cpu cpu = new Cpu(instructions);
        Clock clock = new Clock(List.of(cpu));

        clock.tickTo(20);
        assertEquals(20, cpu.cycles());
        assertEquals(21, cpu.x());
        assertEquals(420, cpu.signal());

        clock.tickTo(60);
        assertEquals(60, cpu.cycles());
        assertEquals(19, cpu.x());
        assertEquals(1140, cpu.signal());

        clock.tickTo(100);
        assertEquals(100, cpu.cycles());
        assertEquals(18, cpu.x());
        assertEquals(1800, cpu.signal());

        clock.tickTo(140);
        assertEquals(140, cpu.cycles());
        assertEquals(21, cpu.x());
        assertEquals(2940, cpu.signal());

        clock.tickTo(180);
        assertEquals(180, cpu.cycles());
        assertEquals(16, cpu.x());
        assertEquals(16 * 180, cpu.signal());

        clock.tickTo(220);
        assertEquals(220, cpu.cycles());
        assertEquals(18, cpu.x());
        assertEquals(3960, cpu.signal());
    }


    private final String source = """
            addx 15
            addx -11
            addx 6
            addx -3
            addx 5
            addx -1
            addx -8
            addx 13
            addx 4
            noop
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx -35
            addx 1
            addx 24
            addx -19
            addx 1
            addx 16
            addx -11
            noop
            noop
            addx 21
            addx -15
            noop
            noop
            addx -3
            addx 9
            addx 1
            addx -3
            addx 8
            addx 1
            addx 5
            noop
            noop
            noop
            noop
            noop
            addx -36
            noop
            addx 1
            addx 7
            noop
            noop
            noop
            addx 2
            addx 6
            noop
            noop
            noop
            noop
            noop
            addx 1
            noop
            noop
            addx 7
            addx 1
            noop
            addx -13
            addx 13
            addx 7
            noop
            addx 1
            addx -33
            noop
            noop
            noop
            addx 2
            noop
            noop
            noop
            addx 8
            noop
            addx -1
            addx 2
            addx 1
            noop
            addx 17
            addx -9
            addx 1
            addx 1
            addx -3
            addx 11
            noop
            noop
            addx 1
            noop
            addx 1
            noop
            noop
            addx -13
            addx -19
            addx 1
            addx 3
            addx 26
            addx -30
            addx 12
            addx -1
            addx 3
            addx 1
            noop
            noop
            noop
            addx -9
            addx 18
            addx 1
            addx 2
            noop
            noop
            addx 9
            noop
            noop
            noop
            addx -1
            addx 2
            addx -37
            addx 1
            addx 3
            noop
            addx 15
            addx -21
            addx 22
            addx -6
            addx 1
            noop
            addx 2
            addx 1
            noop
            addx -10
            noop
            noop
            addx 20
            addx 1
            addx 2
            addx 2
            addx -6
            addx -11
            noop
            noop
            noop
            """;

}