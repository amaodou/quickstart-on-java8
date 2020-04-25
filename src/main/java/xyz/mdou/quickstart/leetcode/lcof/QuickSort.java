package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

    public void quickSort(int[] is) {
        quickSort(is, 0, is.length - 1);
    }

    public void quickSort(int[] is, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int target = is[start];
        while (start < end) {
            while (start < end && target < is[end]) {
                end--;
            }
            if (start < end) {
                is[start++] = is[end];
            }
            while (start < end && target > is[start]) {
                start++;
            }
            if (start < end) {
                is[end--] = is[start];
            }
        }
        if (start >= end) {
            is[start] = target;
        }
        quickSort(is, low, start - 1);
        quickSort(is, start + 1, high);
    }

    @Test
    public void testQuickTest() {
        int[] is = {9, 1, 5, 2, 4, 3, 7};
        Arrays.stream(is).forEach(System.out::print);
        System.out.println();
        quickSort(is);
        Arrays.stream(is).forEach(System.out::print);
    }

    @Test
    public void testDateFormat() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(new Date()));
    }
}
