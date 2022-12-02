package rsvanda.aoc;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Day01 {

    public static void main(String[] args) throws Exception {

        List<Elf> elves = readElves();

        System.out.println("Max calories: " +
                elves.stream()
                        .max(Comparator.comparingInt(Elf::sum))
                        .map(Elf::toString)
                        .orElse("upsik")
        );

        elves.sort(Comparator.comparingInt(Elf::sum).reversed());

        System.out.println(elves.subList(0, 3));

        Integer total = elves.subList(0, 3).stream().map(Elf::sum).reduce(0, Integer::sum);
        System.out.println("Total top 3: " + total);
    }

    private static List<Elf> readElves() throws URISyntaxException, IOException {
        URI uri = Objects.requireNonNull(Day01.class.getResource("/elflist.txt")).toURI();
        try (Stream<String> lines = Files.lines(Path.of(uri))) {
            return lines
                    .reduce(
                            new ArrayList<>(),
                            (elves, src) -> {
                                if (elves.isEmpty()) {
                                    elves.add(new Elf(1));
                                }
                                if ("".equals(src)) {
                                    elves.add(new Elf(elves.size()));
                                } else {
                                    elves.get(elves.size() - 1).calories.add(Integer.parseInt(src));
                                }
                                return elves;
                            },
                            (elves, elves2) -> {
                                elves.addAll(elves2);
                                return elves;
                            }

                    );
        }
    }

    static class Elf implements Comparable<Elf> {
        int ord;
        List<Integer> calories = new ArrayList<>();

        Elf(int ord) {
            this.ord = ord;
        }

        @Override
        public String toString() {
            return "elf=" + ord + ", sum=" + sum() + ", cals=" + calories.toString();
        }

        private Integer sum() {
            return calories.stream().reduce(0, Integer::sum);
        }

        @Override
        public int compareTo(Elf o) {
            return o == null ? 1 : sum() - o.sum();
        }
    }

}
