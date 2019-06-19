package Leetcode;

/**
 * 326. 3的幂 Created by Ping on 2019/6/19.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        double val = Math.log10(n)/Math.log10(3);
        return val == (int)val;
    }

    public static void main(String[] args) {
        PowerofThree powerofThree = new PowerofThree();
        System.out.println(powerofThree.isPowerOfThree(1594324));
        System.out.println(powerofThree.isPowerOfThree(27));
    }
}
