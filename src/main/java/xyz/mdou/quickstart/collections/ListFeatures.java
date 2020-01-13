package xyz.mdou.quickstart.collections;

import java.util.LinkedList;


public class ListFeatures {

    public static void main(final String[] args) {
        LinkedList<String> randoms = new LinkedList<>(Randoms.strings(7));
        System.out.println(randoms);
        System.out.println("getFirst(): " + randoms.getFirst());
        System.out.println("element(): " + randoms.element());
        System.out.println("peek(): " + randoms.peek());
        System.out.println("remove(): " + randoms.remove());
        System.out.println("removeFirst(): " + randoms.removeFirst());
        System.out.println("poll(): " + randoms.poll());
        System.out.println(randoms);
        randoms.addFirst(Randoms.string());
        System.out.println("after addFirst(): " + randoms);
        randoms.offer(Randoms.string());
        System.out.println("after offer(): " + randoms);
        randoms.add(Randoms.string());
        System.out.println("after add(): " + randoms);
        randoms.addLast(Randoms.string());
        System.out.println("after addLast():" + randoms);
        System.out.println("removeLast(): " + randoms.removeLast());
        System.out.println(randoms);
    }
}