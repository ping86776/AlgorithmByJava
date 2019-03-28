package Leetcode;

import java.util.HashSet;


/**
 * 929. 独特的电子邮件地址 Created by Ping on 2019/3/26.
 */
public class UniqueEmailAddresses {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();  //不重复

        for (String str : emails){
            String[] arr = str.split("@");
            arr[0] = arr[0].replace(".","");
            if (arr[0].contains("+")){
                int index = arr[0].indexOf("+");
                arr[0] = arr[0].substring(0,index);
            }
            set.add(arr[0]+arr[1]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] str = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        UniqueEmailAddresses.numUniqueEmails(str);
    }
}
