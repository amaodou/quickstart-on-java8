package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 */
public class MotionRange {

    public int movingCount(int m, int n, int k) {
        boolean[] accessed = new boolean[m * n];
        return movingCount(m, n, k, 0, 0, accessed);
    }

    private int movingCount(int rows, int cols, int target, int pointX, int pointY, boolean[] accessed) {
        if (pointX < 0 || pointY < 0 || pointX >= rows || pointY >= cols) {
            return 0;
        }
        if (!accessed[pointX * cols + pointY] && canAccess(pointX, pointY, target)) {
            accessed[pointX * cols + pointY] = true;
            return 1 + movingCount(rows, cols, target, pointX - 1, pointY, accessed)
                    + movingCount(rows, cols, target, pointX + 1, pointY, accessed)
                    + movingCount(rows, cols, target, pointX, pointY - 1, accessed)
                    + movingCount(rows, cols, target, pointX, pointY + 1, accessed);
        }
        return 0;
    }

    private boolean canAccess(int pointX, int pointY, int target) {
        int x = pointX, y = pointY;
        int pointSum = 0;
        do {
            pointSum += x % 10;
            x /= 10;
        } while (x > 0);
        do {
            pointSum += y % 10;
            y /= 10;
        } while (y > 0);
        return pointSum <= target;
    }

    @Test
    public void testNormal() {
        Assert.assertEquals(3, movingCount(2, 3, 1));
    }
}
