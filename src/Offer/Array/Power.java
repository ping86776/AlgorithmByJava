package Offer.Array;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不得使用库函数直接实现，无需考虑大数问题。
 * 考虑负数则取倒数
 */
public class Power {
    //快速幂 a^n = a^(n/2)*a^(n/2) (幂为偶数) a^n = a^(n-1/2)*a^(n-1/2)*a (幂为奇数)
    public static double power(double base, int exponent) {
        double res = 1.0;
        if (base == 0) return 0;

        int positiveExponent = Math.abs(exponent);
        while (positiveExponent != 0) {
            //如果幂为奇数
            if ((positiveExponent & 1) == 1) {
                res *= base;
            }
            base *= base;
            //在Java的除法中，对于一个奇数n，有n / 2 == (n-1) /2，所以不管奇偶，统一右移一位
            positiveExponent >>= 1;
        }

        return exponent > 0 ? res : 1/res;
    }

    public static double power_2(double base, int exponent) {
        double res = 1.0;
        if (base == 0) return 0;

        int positiveExponent = Math.abs(exponent);

        for (int i = 0; i < positiveExponent; i++) {
            res *= base;
        }

        return exponent > 0 ? res : 1/res;
    }

    public static void main(String[] args) {
        double val = Power.power_2( 2.00000,-2);
        System.out.println(val);
    }
}
