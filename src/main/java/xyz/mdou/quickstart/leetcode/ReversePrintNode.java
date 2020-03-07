package xyz.mdou.quickstart.leetcode;

import lombok.ToString;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;


public class ReversePrintNode {

    @ToString
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    public int[] reversePrint(ListNode head) {
//        ListNode node = head;
//        Stack<ListNode> stack = new Stack<>();
//        while (node != null) {
//            stack.push(node);
//        }
//        int index = 0;
//        int[] nodes = new int[stack.size()];
//        while (!stack.isEmpty()) {
//            nodes[index++] = stack.pop().val;
//        }
//        return nodes;
//    }

    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size += 1;
            node = node.next;
        }
        int[] nodes = new int[size];
        reversePrint(nodes, size - 1, head);
        return nodes;
    }

    public void reversePrint(int[] nodes, int index, ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            nodes[index] = node.val;
            return;
        }
        reversePrint(nodes, index - 1, node.next);
        nodes[index] = node.val;
    }

    @Test
    public void testNull() {
        reversePrint(null);
    }

    @Test
    public void testOnlyOneNode() {
        reversePrint(new ListNode(1));
    }

    @Test
    public void testNormal() {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(7);
        head.next = one;
        one.next = two;
        two.next = three;
        System.out.println(Arrays.toString(reversePrint(head)));
    }
}
