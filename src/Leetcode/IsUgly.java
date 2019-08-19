package Leetcode;

/**
 * 263.判断一个数是否为丑数
 * 思路：对能被2,3,5整除的数不断除2,3,5，最后剩1就是，剩0就不是，除2可以用位运算替换
 */
public class IsUgly {
    public static boolean isUgly(int num) {
        if (num < 1) return false;
        while (num % 2 == 0)
            num >>= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;

        return num == 1;
    }
}
