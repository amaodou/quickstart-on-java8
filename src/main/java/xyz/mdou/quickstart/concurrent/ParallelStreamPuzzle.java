package xyz.mdou.quickstart.concurrent;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamPuzzle {

    public static void main(String[] args) {
        List<Integer> ints = Stream.generate(new IntGenerator())
                .limit(100)
                .parallel()
                .collect(Collectors.toList());
        System.out.println(ints);
    }

    private static class IntGenerator implements Supplier<Integer> {
        int index = 0;

        @Override
        public Integer get() {
            return index++;
        }
    }
}
