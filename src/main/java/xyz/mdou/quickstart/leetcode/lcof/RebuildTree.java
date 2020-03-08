package xyz.mdou.quickstart.leetcode.lcof;

import lombok.ToString;
import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题07. 重建二叉树
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15  7
 * 
 * 限制：
 * 
 * 0 <= 节点个数 <= 5000
 * 
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 */
public class RebuildTree {

    @ToString
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart >= preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preStart]);
        if (preEnd - preStart == 1) {
            return node;
        }
        int leftSize = indexOf(inOrder, preOrder[preStart]) - inStart;
        node.left = buildTree(preOrder, inOrder, preStart + 1, preStart + 1 + leftSize, inStart, inStart + leftSize);
        node.right = buildTree(preOrder, inOrder, preStart + 1 + leftSize, preEnd, inStart + leftSize + 1, inEnd);
        return node;
    }

    private int indexOf(int[] order, int val) {
        for (int i = 0; i < order.length; i++) {
            if (order[i] == val) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testNull() {
        Assert.assertNull(buildTree(null, null));
    }

    @Test
    public void testEmpty() {
        Assert.assertNull(buildTree(new int[]{}, new int[]{}));
    }

    @Test
    public void testNormal() {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
