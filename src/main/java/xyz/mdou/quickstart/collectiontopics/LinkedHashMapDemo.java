package xyz.mdou.quickstart.collectiontopics;

import xyz.mdou.quickstart.CountMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> lruMap = new LinkedHashMap<>(16, 0.75F, true);
        lruMap.putAll(new CountMap(9));
        System.out.println(lruMap);
        lruMap.putAll(new CountMap(3));
        System.out.println(lruMap);
        for (int i = 0; i < 6; i++) {
            lruMap.get(i);
        }
        System.out.println(lruMap);
    }
}
