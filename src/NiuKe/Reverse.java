package NiuKe;

import java.util.*;

/**
 * Created by Ping on 2019/3/8.
 */

/**
 * ������� ��������4���ַ�(�磺abcd)�� �����������(�磺dcba)
 */
public class Reverse{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        while(in.hasNext()){
            String str = in.nextLine();
            for(int i=0; i<str.length(); i++){
                list.add(str.substring(i,i+1));
            }
            for(int i=list.size()-1; i>=0; i--){
                sb.append(list.get(i));
            }
            String res = sb.toString();
            System.out.println(res);
        }
    }
}