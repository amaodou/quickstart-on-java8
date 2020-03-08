package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        if (s == null) {
            return s;
        }
        long spaceCount = s.chars().filter(c -> c == ' ').count();
        if (spaceCount == 0) {
            return s;
        }
        char[] newChars = new char[(int) (s.length() + spaceCount * 2)];
        int newIndex = newChars.length - 1;
        int originIndex = s.length() - 1;
        while (newIndex >= 0) {
            char o = s.charAt(originIndex);
            if (s.charAt(originIndex) == ' ') {
                newChars[newIndex--] = '0';
                newChars[newIndex--] = '2';
                newChars[newIndex] = '%';
            } else {
                newChars[newIndex] = s.charAt(originIndex);
            }
            originIndex -= 1;
            newIndex -=1;
        }
        return new String(newChars);
    }

    @Test
    public void testReplaceNull() {
        Assert.assertNull(replaceSpace(null));
    }

    @Test
    public void testReplaceEmpty() {
        Assert.assertEquals("", replaceSpace(""));
    }

    @Test
    public void testReplaceNormal() {
        String s = "We are happy.";
        String expect = "We%20are%20happy.";
        Assert.assertEquals(expect, replaceSpace(s));
    }
}
