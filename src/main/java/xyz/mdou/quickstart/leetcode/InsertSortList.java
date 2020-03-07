package xyz.mdou.quickstart.leetcode;

/**
 * 面试题06. 从尾到头打印链表
 *
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 */
public class InsertSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sorted = head;
        while (sorted.next != null) {
            ListNode nextInsert = sorted.next;
            sorted.next = nextInsert.next;
            nextInsert.next = null;

            ListNode current = head;
            ListNode pre = null;
            while (current != sorted.next) {
                if (current.val < nextInsert.val) {
                    if (current == sorted) {
                        nextInsert.next = sorted.next;
                        sorted.next = nextInsert;
                        sorted = nextInsert;
                        break;
                    }
                    pre = current;
                    current = current.next;
                } else {
                    nextInsert.next = current;
                    if (pre == null) {
                        head = nextInsert;
                    } else {
                        pre.next = nextInsert;
                    }
                    break;
                }               
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}