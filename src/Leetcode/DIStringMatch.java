package Leetcode;

import java.util.Arrays;

/**
 *  942. 增减字符串匹配 Created by Ping on 2019/3/24.
 */

public class DIStringMatch {
    public static int[] diStringMatch(String S) {
        int N = S.length();
        int[] A = new int[N+1];
        int min = 0, max = N;
        for (int i = 0; i < N; i++) {
            A[i] = S.charAt(i)=='I'? min++:max--;   //这边要注意的就是先赋值再自增自减
        }
        A[N] = min;     //max min都行
        return A;
    }
    //这里题目没讲清楚，按原文意思是只要当前是I则一定比下个索引的值小，反则一定比下一个索引大
    //下面是满足此题意的算法
    public static int[] diStringMatch1(String S) {
        int[] A = new int[S.length()+1];
        for (int i = 0; i < A.length; i++) {
                A[i] = i;
            }
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i)=='I'){
                if (A[i]>A[i+1]){
                    swap(A, i, i+1);
                }
            }else if (S.charAt(i)=='D'){
                if (A[i]<A[i+1]){
                    swap(A, i, i+1);
                }
            }
        }
        return A;
    }

    public static int[] swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }

    public static void main(String[] args) {
        String s = "IDID";
        System.out.println(Arrays.toString(DIStringMatch.diStringMatch1(s)));
    }
}
