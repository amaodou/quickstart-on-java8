package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * <p>
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 * 限制：
 * 2 <= nums <= 10000
 * <p>
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 */
public class FindArraySingleNumbers {

    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        int divideNum = xorResult - (xorResult & (xorResult - 1));
        int[] singleNums = new int[]{0, 0};
        for (int num : nums) {
            if ((num & divideNum) == 0) {
                singleNums[0] ^= num;
            } else {
                singleNums[1] ^= num;
            }
        }
        return singleNums;
    }

    @Test
    public void testNull() {
        Assert.assertArrayEquals(new int[]{}, singleNumbers(null));
    }

    @Test
    public void testEmpty() {
        Assert.assertArrayEquals(new int[]{}, singleNumbers(new int[]{1}));
    }

    @Test
    public void testNormal() {
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, singleNumbers(new int[]{1, 2}))
                || Arrays.equals(new int[]{2, 1}, singleNumbers(new int[]{1, 2})));
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, singleNumbers(new int[]{4, 1, 4, 2, 6, 6}))
                || Arrays.equals(new int[]{2, 1}, singleNumbers(new int[]{4, 1, 4, 2, 6, 6})));
    }
}
