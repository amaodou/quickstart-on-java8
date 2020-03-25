package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题17. 打印从1到最大的n位数
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 */
public class PrintNumbers {

    private int[] numbers;
    private int numberIndex = 0;

    public int[] printNumbers(int n) {
        numbers = new int[(int) (Math.pow(10, n) - 1)];
        int[] number = new int[n];
        printNumbers(number, n, 0);
        return numbers;
    }

    private void printNumbers(int[] number, int length, int index) {
        if (index >= length) {
            saveNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = i;
            printNumbers(number, length, index + 1);
        }
    }

    private void saveNumber(int[] number) {
        StringBuilder s = new StringBuilder();
        boolean preZero = true;
        for (int c : number) {
            if (c == 0 && preZero) {
                continue;
            }
            preZero = false;
            s.append(c);
        }
        if (!s.toString().equals("")) {
            numbers[numberIndex] = Integer.parseInt(s.toString());
            numberIndex += 1;
        }
    }

    @Test
    public void testNormal() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, printNumbers(1));
    }
}
