package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 905. Sort Array By Parity 按奇偶排序数组 Created by Ping on 2019/3/25.
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2==0){
                list.add(A[i]);
            }else list2.add(A[i]);
        }
        list.addAll(list2);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(A)));
    }
}
