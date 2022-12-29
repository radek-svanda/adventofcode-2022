package rsvanda.day15;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Interval {

    public static final Interval EMPTY = new Interval();

    private List<Range> ranges = new LinkedList<>();

    public static Interval of(long from, long to) {
        Interval interval = new Interval();
        interval.append(Range.range(from, to));
        return interval;
    }

    public long size() {
        return ranges.stream().mapToLong(Range::size).sum();
    }

    public void append(Interval other) {
        other.ranges.forEach(this::append);
    }

    private void append(Range other) {
        ranges.add(other);
        ranges = ranges.stream().sorted()
                .reduce(
                        new LinkedList<>(),
                        (existing, current) -> {
                            if (existing.isEmpty()) {
                                existing.addLast(current);
                            } else if (existing.getLast().overlaps(current)) {
                                existing.getLast().merge(current);
                            } else {
                                existing.addLast(current);
                            }
                            return existing;
                        },
                        (ranges1, ranges2) -> ranges1
                );
    }

    public Interval sub(long min, long max) {

        Interval other = new Interval();
        ranges.stream()
                .filter(range -> range.to >= min)
                .filter(range -> range.from <= max)
                .map(range -> {
                    if (range.from < min) {
                        range.from = min;
                    }
                    if (range.to > max) {
                        range.to = max;
                    }
                    return range;
                })
                .forEach(other::append);

        return other;
    }

    public List<Long> gaps() {
        List<Long> res = new ArrayList<>();
        for (int i = 1; i < ranges.size(); i++) {
            Range curr = ranges.get(i);
            Range prev = ranges.get(i - 1);
            if (prev.to + 1 < curr.from) {
                res.add(prev.to + 1);
            }
        }
        return res;
    }

    static final class Range implements Comparable<Range> {
        private long from;
        private long to;

        public Range(long from, long to) {
            this.from = from;
            this.to = to;
        }

        public long size() {
            return to - from + 1;
        }

        public boolean overlaps(Range other) {
            return from <= other.from && other.from <= to
                    || from >= other.from && to <= other.to
                    || from >= other.from && from <= other.to;
        }

        public void merge(Range other) {
            from = min(from, other.from);
            to = max(to, other.to);
        }

        public static Range range(long from, long to) {
            return new Range(from, to);
        }

        @Override
        public int compareTo(Range o) {
            return (int) (from - o.from);
        }
    }

}
