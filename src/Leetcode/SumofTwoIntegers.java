package Leetcode;

/**
 * 371. 两整数之和 Created by Ping on 2019/5/31.
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        //a^b是无进位相加，a & b得到进位的1，因为是进位所以要左移一位代表进位，
        // 如果进位不等于0，那么就是说还要把进位给加上去，所以递归
        return b == 0 ? a : getSum(a^b,(a&b)<<1);
    }

    public static void main(String[] args) {
        SumofTwoIntegers s = new SumofTwoIntegers();
        System.out.println(s.getSum(1,-2));
        System.out.println((5&3)<<1);
    }
}
