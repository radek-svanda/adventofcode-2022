package rsvanda.day10;

import java.util.List;
import java.util.stream.IntStream;

public class Day10 {

    public static void main(String[] args) {
        List<Instruction> instructions = Instruction.parse(Day10.class.getResourceAsStream("/input.txt"));

//        checkSignal(instructions);

        //RKAZAJBR
        drawCrt(instructions);

    }

    private static void drawCrt(List<Instruction> instructions) {

        Cpu cpu = new Cpu(instructions);
        Crt crt = new Crt(cpu);
        Clock clock = new Clock(List.of(cpu, crt));

        clock.tick(instructions.stream().mapToInt(Instruction::duration).sum());

    }

    private static void checkSignal(List<Instruction> instructions) {
        Cpu cpu = new Cpu(instructions);
        Clock clock = new Clock(List.of(cpu));

        int firstSum = IntStream.of(20, 60, 100, 140, 180, 220)
                .map(i -> {
                    clock.tickTo(i);
                    return cpu.signal();
                })
                .sum();

        // 16880
        System.out.println("First: " + firstSum);
    }


}
