package rsvanda.day10;

import java.util.LinkedList;
import java.util.List;

public class Cpu implements Timed {

    private int x = 1;
    private int next = 1;

    private final LinkedList<Instruction> instructions;

    private Instruction current;

    private int cycles = 0;

    public Cpu(List<Instruction> instructions) {
        this.instructions = new LinkedList<>(instructions);
    }

    @Override
    public void tick() {
        x = next;
        if (current == null || current.finished()) {
            current = instructions.removeFirst();
        }
        current.tick(this);
        this.cycles += 1;
    }

    public Instruction current() {
        return current;
    }

    public int x() {
        return x;
    }

    public void x(int value) {
        next = value;
    }

    public int cycles() {
        return cycles;
    }

    public int signal() {
        if (cycles == 20 || ((cycles - 20) % 40) == 0) {
            return cycles * x;
        }
        throw new IllegalStateException();
    }

}
