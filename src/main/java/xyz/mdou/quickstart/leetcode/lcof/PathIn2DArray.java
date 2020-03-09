package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题12. 矩阵中的路径
 * 
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * 
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 
 * 示例 1：
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * 
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 */
public class PathIn2DArray {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        boolean[][] access = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean exist = exist(board, i, j, word, 0, access);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, String word, int hitCount, boolean[][] access) {
        if (hitCount >= word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length
                || access[x][y] || word.charAt(hitCount) != board[x][y]) {
            return false;
        }
        access[x][y] = true;
        hitCount += 1;
        boolean exist = exist(board, x - 1, y, word, hitCount, access)
                || exist(board, x + 1, y, word, hitCount, access)
                || exist(board, x, y - 1, word, hitCount, access)
                || exist(board, x, y + 1, word, hitCount, access);
        if (!exist) {
            access[x][y] = false;
        }
        return exist;
    }

    @Test
    public void testNullArray() {
        Assert.assertFalse(exist(null, "bfce"));
    }

    @Test
    public void testNullWord() {
        Assert.assertFalse(exist(new char[][]{{'a', 'b', 'c', 'e'}}, null));
    }

    @Test
    public void testNormal() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";
        Assert.assertTrue(exist(board, word));
    }
}
