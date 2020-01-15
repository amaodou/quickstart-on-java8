package xyz.mdou.quickstart.collectiontopics;

import xyz.mdou.quickstart.Countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Synchronization {
    public static void main(String[] args) {
        Collection<String> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        syncCollection.addAll(Countries.name(6));
        System.out.println(syncCollection);

        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.addAll(Countries.name(6));
        System.out.println(syncList);

        Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
        syncSet.addAll(Countries.name(6));
        System.out.println(syncSet);

        Set<String> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());
        syncSortedSet.addAll(Countries.name(6));
        System.out.println(syncSortedSet);

        Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        syncMap.putAll(Countries.capitals(6));
        System.out.println(syncMap);

        Map<String, String> syncTreeMap = Collections.synchronizedSortedMap(new TreeMap<>());
        syncTreeMap.putAll(Countries.capitals(6));
        System.out.println(syncTreeMap);
    }
}
