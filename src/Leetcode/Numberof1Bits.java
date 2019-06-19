package Leetcode;

/**
 * 191. 位1的个数 Created by Ping on 2019/6/19.
 */
public class Numberof1Bits {
    // you need to treat n as an unsigned value
    //把 n 与 1 进行与运算，将得到 n 的最低位数字。因此可以取出最低位数，再将 n 右移一位。循环此步骤，直到 n 等于零。
    public int hammingWeight(int n) {
        if(n == 0) return 0;
        int count = 0;
        for(int i = 0; i < 32; i++){
            count += n & 1; //得到最低位
            System.out.println(n & 1);
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Numberof1Bits numberof1Bits = new Numberof1Bits();
        numberof1Bits.hammingWeight(3);
    }
}
