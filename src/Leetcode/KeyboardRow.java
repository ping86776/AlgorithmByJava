package Leetcode;

/**
 * 500. Keyboard Row
 */

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] str = new String[]{"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};

        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            for (String s : words){
                for (int j = 0; j < s.length(); j++) {
                    if (str[i].indexOf(s.toUpperCase().charAt(j))!=-1){
                        count++;
                    }
                }
                if (count==s.length()){
                    list.add(s);
                }
                count = 0;
            }
        }
        System.out.println(list);

        return list.toArray(new String[]{});


    }

    public static void main(String[] args) {
        String[] test = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        KeyboardRow k = new KeyboardRow();
        k.findWords(test);

    }
}
