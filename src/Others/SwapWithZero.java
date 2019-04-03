package Others;

import java.util.Arrays;

/**
 * 华为笔试题 长度为n的数组乱序存放着0至n-1. 现在只能进行0与其他数的交换，完成数组排序
 * Created by Ping on 2019/4/3.
 * 思路是 由于最终的结果是array[i]=i,所以先把0交换到末尾array[i]，然后往前遍历
 * 填充i
 */
public class SwapWithZero {
    /**
     * 与0交换
     * @param array 长度为n的数组乱序存放着0至n-1
     * @param len   数组长度
     * @param n 要和0交换的数
     */
    public void swap_with_zero(int[] array, int len, int n){
        int temp = array[n];
        array[n] = array[0];
        array[0] = temp;
//        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array, int len){
        for (int i = len - 1; i > 0; i--) {
            swap_with_zero(array,len,array[i]);
            swap_with_zero(array,len,i);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,3,2,4};
        SwapWithZero S = new SwapWithZero();
        S.swap_with_zero(arr,arr.length,4);
        S.sort(arr,arr.length);
    }
}
