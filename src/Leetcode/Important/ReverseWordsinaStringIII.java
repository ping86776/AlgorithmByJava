package Leetcode.Important;


/**
 *  557. Reverse Words in a String III
 *
 *  Created by Ping on 2019/4/30.
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        String res = "";
        for (int i = 0; i < str.length-1; i++) {
            res += Reverse(str[i]) +" ";
        }
        res += Reverse(str[str.length-1]);
        System.out.println(res);
        return res;

    }

    public String Reverse(String s1){
        int i = 0, j = s1.length()-1;
        char[] c = s1.toCharArray();
        while (i<j){
            swapthis(c, i, j);
            i++;
            j--;
        }
        return String.valueOf(c);
    }

    public void swapthis(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
//        String[] str = s.split(" ");
//        System.out.println(Arrays.toString(str));
        ReverseWordsinaStringIII r = new ReverseWordsinaStringIII();
        r.reverseWords(s);
    }
}
