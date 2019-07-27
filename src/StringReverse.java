
import java.util.Arrays;

public class StringReverse {
    public static void main(String[] args) {
        String str = "ABCDEFGH";
        int j = str.length()-1;
//        System.out.println(j);
        int mid = str.length()/2;
//        System.out.println(mid);
        char[] arr = str.toCharArray();
//        System.out.println(Arrays.toString(arr));
        while (mid<j){
            StringReverse.swap(arr, mid, j);
            mid++;
            j--;
        }
        System.out.println(arr);
    }

    public static void swap (char[] arr, int i, int j) {
       char temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }
}
