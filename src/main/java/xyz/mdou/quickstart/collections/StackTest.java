package xyz.mdou.quickstart.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class StackTest {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        IntStream.range(0, 3).boxed().forEach(stack::push);
        System.out.println(stack);
        while (!stack.isEmpty()) {
            System.out.println("poll(): " + stack.poll());
        }
    }
}
