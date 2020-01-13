package xyz.mdou.quickstart.collections;

import java.util.Iterator;

public class IterableClass implements Iterable<String> {

    static String[] words = "And that is how we know the Earth to be banana-shaped.".split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        for (String word : new IterableClass()) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }
}
