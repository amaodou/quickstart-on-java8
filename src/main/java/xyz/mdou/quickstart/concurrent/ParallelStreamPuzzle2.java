package xyz.mdou.quickstart.concurrent;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamPuzzle2 {

    static Deque<String> trace = new ConcurrentLinkedDeque<>();


    public static void main(String[] args) {
        List<Integer> ints = Stream.generate(new IntGenerator())
                .limit(1000)
                .parallel()
                .collect(Collectors.toList());
        System.out.println(ints);
        System.out.println(trace);
    }

    static class IntGenerator implements Supplier<Integer> {
        AtomicInteger ai = new AtomicInteger();

        @Override
        public Integer get() {
            trace.add(ai.get() + ": " + Thread.currentThread().getName());
            return ai.getAndIncrement();
        }
    }
}
