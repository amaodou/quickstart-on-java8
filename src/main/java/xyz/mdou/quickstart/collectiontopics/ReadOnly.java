package xyz.mdou.quickstart.collectiontopics;

import xyz.mdou.quickstart.Countries;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ReadOnly {
    static List<String> list = Countries.names();

    public static void main(String[] args) {
        Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(list);
        System.out.println(unmodifiableCollection);
//        unmodifiableCollection.add("abc");

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println(unmodifiableList);
//        unmodifiableList.add("abc");

        Set<String> unmodifiableSet = Collections.unmodifiableSet(new HashSet<>(list));
        System.out.println(unmodifiableSet);
//        unmodifiableSet.add("abc");

        Set<String> unmodifiableSortedSet = Collections.unmodifiableSortedSet(new TreeSet<>(list));
        System.out.println(unmodifiableSortedSet);
//        unmodifiableSortedSet.add("abc");

        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(Countries.capitals(5));
        System.out.println(unmodifiableMap);
//        unmodifiableMap.put("abc", "abc");

        Map<String, String> unmodifiableSortedMap = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.capitals(10)));
        System.out.println(unmodifiableSortedMap);
//        unmodifiableSortedMap.put("abc", "abc");
    }
}
