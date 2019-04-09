package Leetcode;

/**
 * 344. Reverse String Created by Ping on 2019/4/9.
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i<j){
            swap(s,i,j);
            i++;
            j--;
        }
        System.out.println(s);
    }
    public void swap(char[] ch,int i,int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        ReverseString reverseString =new ReverseString();
        reverseString.reverseString(s);
    }
}
