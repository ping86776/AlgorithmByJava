package Others;

import java.util.Arrays;

/**
 * 判断是否为回文串 Created by Ping on 2019/3/28.
 */

public class Phrase {
    public int find(int n) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i;
        }
        System.out.println(Arrays.toString(num));
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (ishuiwen(Integer.toBinaryString(num[i]))) count++;
            System.out.println(Integer.toBinaryString(num[i]));
        }
        return count;
    }

    public boolean ishuiwen(String str) {
        int flag = 0;
        int N = str.length() - 1;
        if (str.equals("0") || str.equals("1")) return true;
        if (str.length() == 3) {
            if (str.charAt(0) == str.charAt(N)) return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(N - i)) {
                if (N - 2 * i != 1) {
                    flag++;
                } else if (flag % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        Phrase demo = new Phrase();
        String str = "101";
        System.out.println(demo.ishuiwen(str));
        System.out.println(demo.find(100));
        demo.find(9);
//        System.out.println(Arrays.toString(demo.twoSum(arr, 13)));

    }
}