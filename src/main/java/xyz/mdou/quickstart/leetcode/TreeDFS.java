package xyz.mdou.quickstart.leetcode;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringJoiner;

public class TreeDFS {
    private static int index = 0;

    public static void main(String[] args) {
        char[] nodes = new char[]{'A', 'B', 'D', '#', '#', 'E', '#', '#', 'C', 'F','#', '#', 'G', '#', '#'};
        TreeNode rootNode = buildTree(nodes);
        System.out.println(rootNode);
        treeDFS(rootNode);
        treeBFS(rootNode);
    }

    private static TreeNode buildTree(char[] nodes) {
        if (index >= nodes.length) {
            return null;
        }
        char ch = nodes[index++];
        if (ch == '#') {
            return null;
        }
        TreeNode rootNode = new TreeNode();
        rootNode.value = ch;
        rootNode.left = buildTree(nodes);
        rootNode.right = buildTree(nodes);
        return rootNode;
    }

    private static void treeDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        System.out.print("\r\nnode: ");
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    private static void treeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.print("\r\nnode: ");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}

@Data
class TreeNode {
    TreeNode left;
    TreeNode right;
    char value;

}