package xyz.mdou.quickstart.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.stream.IntStream;

public class PriorityQueueDemo {

    static Random random = new Random(47);

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        IntStream.range(0, 6).forEach(i -> priorityQueue.offer(random.nextInt(50)));
        printQueue(priorityQueue);

        List<Integer> numbers = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> numbers.add(random.nextInt(50)));
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(numbers);
        printQueue(priorityQueue2);

        PriorityQueue<Integer> priorityQueue3 = new PriorityQueue<>(numbers.size(), Collections.reverseOrder());
        priorityQueue3.addAll(numbers);
        printQueue(priorityQueue3);
    }

    static <T> void printQueue(Queue<T> queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
