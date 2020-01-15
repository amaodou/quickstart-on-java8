package xyz.mdou.quickstart.collectiontopics;

import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class NavMap {

    public static void main(String[] args) {
        NavigableMap<Integer, String> navMap = new ConcurrentSkipListMap<>(HTMLColors.MAP);
        HTMLColors.show(navMap.firstEntry());
        HTMLColors.border();
        HTMLColors.show(navMap.lastEntry());
        HTMLColors.border();
        HTMLColors.show(navMap.headMap(HTMLColors.rgb("Lime"), true));
        HTMLColors.border();
        HTMLColors.show(navMap.ceilingEntry(HTMLColors.rgb("DeepSkyBlue") - 1));
        HTMLColors.border();
        HTMLColors.show(navMap.floorEntry(HTMLColors.rgb("DeepSkyBlue") - 1));
        HTMLColors.border();
        HTMLColors.show(navMap.subMap(HTMLColors.rgb("DeepSkyBlue"), true, HTMLColors.rgb("Lime"), true));
        HTMLColors.border();
        HTMLColors.show(navMap.descendingMap());
        HTMLColors.border();
        HTMLColors.show(navMap.tailMap(HTMLColors.rgb("SeaShell")));
    }
}
