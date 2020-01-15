package xyz.mdou.quickstart.collectiontopics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListOps {

    static List<String> LIST = HTMLColors.LIST.subList(0, 10);

    static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        System.out.println("hasPrevious: " + it.hasPrevious());
        it.add("47");
        System.out.println("hasPrevious: " + it.hasPrevious());
        System.out.println("nextIndex: " + it.nextIndex());
        print(it);
        print(a);
    }

    static <T> void print(Iterator<T> it) {
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    static <T> void print(Collection<T> cs) {
        for (T t : cs) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        iterManipulation(new ArrayList<>(LIST));
    }
}
