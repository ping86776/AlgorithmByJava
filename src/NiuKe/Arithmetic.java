package NiuKe;

/**
 * Created by Ping on 2019/3/9.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入包括两行,第一行包含整数n(2 ≤ n ≤ 50),即数列的长度。
   第二行n个元素x[i](0 ≤ x[i] ≤ 1000),即数列中的每个整数。
   判断排序后是否可以成为等差数列
 */
public class Arithmetic {
    public String P = "Possible";
    public String I = "Impossible";
    public String Arithmetic (int n, int[] x){
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < x[i]){
                max = x[i];
            }
        }
        int min = max;
        for (int j = 0; j < n; j++) {
            if (min > x[j]){
                min = x[j];
            }
        }
        //公差为0
        if (max == min) return P;
        //公差不存在
        if ((max-min)%(n-1)!=0) return I;
        int tolerance = (max-min)/(n-1);
        //这里数组中的每个数与最小值的差值，对公差取模(%)的结果应该都是0，否则就不是等差数列
        for (int i = 0; i < n; i++) {
            if ((x[i]-min)%tolerance!=0){
                return I;
            }
        }
        return P;
    }

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        Arithmetic arithmetic = new Arithmetic();
        System.out.println(arithmetic.Arithmetic(n,arr));

    }
}
