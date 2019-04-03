package Others;

import java.util.Arrays;

/**
 * ��Ϊ������ ����Ϊn��������������0��n-1. ����ֻ�ܽ���0���������Ľ����������������
 * Created by Ping on 2019/4/3.
 * ˼·�� �������յĽ����array[i]=i,�����Ȱ�0������ĩβarray[i]��Ȼ����ǰ����
 * ���i
 */
public class SwapWithZero {
    /**
     * ��0����
     * @param array ����Ϊn��������������0��n-1
     * @param len   ���鳤��
     * @param n Ҫ��0��������
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
