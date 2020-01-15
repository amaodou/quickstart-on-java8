package xyz.mdou.quickstart.collectiontopics;

import xyz.mdou.quickstart.Countries;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class FailFast {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Countries.name(10));
        ListIterator<String> iter = list.listIterator();
        list.addFirst("abce");
        try {
            System.out.println(iter.next());
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        iter = list.listIterator(7);
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        System.out.println(list);
    }
}
