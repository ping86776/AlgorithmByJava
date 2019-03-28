package NiuKe;

/**
 * Created by Ping on 2019/3/9.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * �����������,��һ�а�������n(2 �� n �� 50),�����еĳ��ȡ�
   �ڶ���n��Ԫ��x[i](0 �� x[i] �� 1000),�������е�ÿ��������
   �ж�������Ƿ���Գ�Ϊ�Ȳ�����
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
        //����Ϊ0
        if (max == min) return P;
        //�������
        if ((max-min)%(n-1)!=0) return I;
        int tolerance = (max-min)/(n-1);
        //���������е�ÿ��������Сֵ�Ĳ�ֵ���Թ���ȡģ(%)�Ľ��Ӧ�ö���0������Ͳ��ǵȲ�����
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
