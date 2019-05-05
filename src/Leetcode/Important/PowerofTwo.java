package Leetcode.Important;

/**
 * 231. Power of Two
 * 一个数是2的幂，二进制下只有1位是1，减去1的情况如果不止1位是1，那首位肯定是1
 * 即n和n-1最高位都是1，则与运算下就不会等于0
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }
    public boolean isPowerOfTwo2(int n) {
        return (n & (~n+1)) == n;
    }
    public static void main(String[] args) {
        PowerofTwo p = new PowerofTwo();
        System.out.println(p.isPowerOfTwo2(16));

    }
}
