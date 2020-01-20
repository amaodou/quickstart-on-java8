package xyz.mdou.quickstart.concurrent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamPuzzle3 {

    public static void main(String[] args) {
        List<Integer> ints = IntStream.range(0, 1000)
                .peek(i -> System.out.println(i + ": " + Thread.currentThread().getName()))
                .parallel()
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);
    }
}
