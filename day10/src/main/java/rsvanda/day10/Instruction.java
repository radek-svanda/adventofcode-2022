package rsvanda.day10;

import rsvanda.InputStreams;

import java.io.*;
import java.util.List;

abstract class Instruction {

    private int ticks = 0;

    public static Instruction parse(String input) {
        if (input.length() < 4) {
            throw new IllegalArgumentException(input);
        }

        return switch (input.substring(0, 4)) {
            case "noop" -> new Noop();
            case "addx" -> new Addx(Integer.parseInt(input.substring(5)));
            default -> throw new IllegalArgumentException(input);
        };
    }

    public static List<Instruction> parse(InputStream stream) {
        return InputStreams.streamToList(stream, Instruction::parse);
    }

    public void tick(Cpu cpu) {
        this.ticks += 1;
    }

    protected int tics() {
        return ticks;
    }

    public boolean finished() {
        return ticks >= duration();
    }

    abstract int duration();

    public static class Noop extends Instruction {
        @Override
        int duration() {
            return 1;
        }
    }

    public static class Addx extends Instruction {
        private final int value;

        public Addx(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        int duration() {
            return 2;
        }

        @Override
        public void tick(Cpu cpu) {
            super.tick(cpu);
            if (tics() == duration()) {
                cpu.x(cpu.x() + value);
            }
        }
    }

}
