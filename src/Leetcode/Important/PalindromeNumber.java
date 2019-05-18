package Leetcode.Important;

/**
 * 9.回文数 Created by Ping on 2019/4/29.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i = 0, j = str.length()-1;
        int flag = 0;
        while (i<j){
            if (str.charAt(i)==str.charAt(j)){
                flag++;
            }
            i++;
            j--;
        }
        //偶数
        if ((str.length()&1)==0){
            if (flag==str.length()/2) return true;
        }
        //奇数
        if ((str.length()&1)==1){
            if (flag==(str.length()-1)/2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(1100011));
    }
}
