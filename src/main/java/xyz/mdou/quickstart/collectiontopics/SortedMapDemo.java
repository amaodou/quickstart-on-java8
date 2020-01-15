package xyz.mdou.quickstart.collectiontopics;

import xyz.mdou.quickstart.CountMap;

import java.util.Map;
import java.util.TreeMap;

public class SortedMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.putAll(new CountMap(10));
        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        Map.Entry<Integer, String> lowerEntry = map.lowerEntry(5);
        System.out.println(lowerEntry);
        Map.Entry<Integer, String> higherEntry = map.higherEntry(5);
        System.out.println(higherEntry);
        Map<Integer, String> tailMap = map.tailMap(5, true);
        System.out.println(tailMap);
        Map<Integer, String> subMap = map.subMap(4, 8);
        System.out.println(subMap);

    }
}
