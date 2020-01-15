package xyz.mdou.quickstart.collectiontopics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListSortSearch {
    static List<String> LIST = Arrays.asList(
            "one Two three Four five six one".split(" "));

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(LIST);
        list.addAll(LIST);
        System.out.println(list);
        Collections.shuffle(list, new Random(47));
        System.out.println(list);
        ListIterator<String> iter = list.listIterator(10);
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        String key = list.get(1);
        int index = Collections.binarySearch(list, key);
        System.out.printf("key: %s, index: %d\r\n", key, index);

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);
        key = list.get(1);
        index = Collections.binarySearch(list, key);
        System.out.printf("key: %s, index: %d\r\n", key, index);
    }
}
