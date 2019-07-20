package NiuKe;

public class TranforInteger {
    public static int StrToInt(String str){
        if (str.length()<1) return 0;
        int flag = 1;
        if (str.charAt(0)=='-') flag = -1;

        int res = 0;

        for (int i = (str.charAt(0) == '+' || str.charAt(0) == '-')? 1 : 0; i < str.length(); i++) {
            //ASCII码中"0"比0高了4个二进制位，0xf 是数字15，二进制位1111
            //与操作后就可以将"0"转化为0，...，将"9"转化为9
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                res = res * 10 + (str.charAt(i) & 15);
            }else
                return 0;

        }
        System.out.println(res);
        return res * flag;
    }
    public static void main(String[] args) {
        String str ="";
        long a = TranforInteger.StrToInt(str);
        System.out.println(a);
    }
}
