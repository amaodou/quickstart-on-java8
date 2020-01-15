package xyz.mdou.quickstart.collectiontopics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@SuppressWarnings("ALL")
public class SetOps {

    static String[] sets = {
            "java.util.HashSet",
            "java.util.TreeSet",
            "java.util.concurrent.ConcurrentSkipListSet",
            "java.util.LinkedHashSet",
            "java.util.concurrent.CopyOnWriteArraySet",
    };

    static List<String> LIST = new ArrayList<>(HTMLColors.LIST);

    public static void main(String[] args) throws Exception {
        for (String t : sets) {
            System.out.printf("*******%s********\r\n", t.substring(t.lastIndexOf(".") + 1));
            Set<String> set = (Set<String>) Class.forName(t).newInstance();
            Collections.reverse(LIST);
            LIST.stream().limit(10).forEach(System.out::println);
            System.out.println("********************");
            set.addAll(LIST);
            set.stream().limit(10).forEach(System.out::println);
        }
    }
}
