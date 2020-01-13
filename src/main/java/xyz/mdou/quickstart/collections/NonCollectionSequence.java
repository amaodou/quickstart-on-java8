package xyz.mdou.quickstart.collections;

import java.util.Iterator;

class CollectionSequence {

    int[] numbers = {1, 2, 3, 4, 5, 6, 7};
}

public class NonCollectionSequence extends CollectionSequence {

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < numbers.length;
            }

            @Override
            public Integer next() {
                return numbers[index++];
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence sequence = new NonCollectionSequence();
        display(sequence.iterator());
    }

    static <T> void display(Iterator<T> iter) {
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}
