package xyz.mdou.quickstart.collectiontopics;

import xyz.mdou.quickstart.Suppliers;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;


class Government implements Supplier<String> {
    static String[] foundation = (
            "strange women lying in ponds " +
                    "distributing swords is no basis " +
                    "for a system of government").split(" ");
    private int index;

    @Override
    public String get() {
        return foundation[index++];
    }
}

public class SuppliersCollectionTest {

    public static void main(String[] args) {
        List<String> list = Arrays.stream(Government.foundation).collect(Collectors.toList());
        System.out.println(list);

        Set<String> set = Arrays.stream(Government.foundation).collect(Collectors.toSet());
        System.out.println(set);

        list = Arrays.stream(Government.foundation).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(list);

        set = Arrays.stream(Government.foundation).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set);

        list = Suppliers.create(LinkedList::new, new Government(), 15);
        System.out.println(list);

        set = Suppliers.create(LinkedHashSet::new, new Government(), 15);
        System.out.println(set);

        Suppliers.fill(list, new Government(), 15);
        Suppliers.fill(list, (String o1, List<String> o2) -> o2.add(o1), new Government(), 15);
    }
}
