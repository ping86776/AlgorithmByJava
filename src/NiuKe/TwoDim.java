package NiuKe;

/**
 * Created by Ping on 2019/3/20.
 */

/**
 * ��ά����Ĳ��ң���һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ��������
 * �ж��������Ƿ��и�������
 */
public class TwoDim {
    public static boolean Find (int[][] arr, int n){
        int row = 0;    //������
        int col = arr[0].length-1;    //������
        while (row<=arr.length-1&&col>=0){
            if (n==arr[row][col]){
                return true;
            }else if (n<arr[row][col]){     //n�ȵ�ǰλ��С����һ���������
                col--;
            }else if (n>arr[row][col]){     //n�ȵ�ǰλ�ô���һ�������±�
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(TwoDim.Find(arr, 7));

    }
}
