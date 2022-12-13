package rsvanda.day10;

import java.util.List;
import java.util.stream.IntStream;

public class Day10 {

    public static void main(String[] args) {
        List<Instruction> instructions = Instruction.parse(Day10.class.getResourceAsStream("/input.txt"));

        Cpu cpu = new Cpu(instructions);

        int firstSum = IntStream.of(20, 60, 100, 140, 180, 220)
                .map(i -> {
                    cpu.executeTo(i);
                    return cpu.signal();
                })
                .sum();

        // 16880
        System.out.println("First: " + firstSum);

    }
}
