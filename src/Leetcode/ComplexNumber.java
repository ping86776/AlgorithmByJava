package Leetcode;

/**
 * 537. Complex Number Multiplication
 */

public class ComplexNumber {
    public String complexNumberMultiply(String a, String b) {
        String tempW = "";
        String tempZ = "";
        String i = "i";
        int x = findOne(a);
        int y = findOne(b);
        int w = find(a);
        int z = find(b);
        //结果是 (ac-bd) + (ad+bc)i 的形式
        int start = x * y - w * z;
        int end = x * z + y * w;
        String str = String.valueOf(start)+"+"+String.valueOf(end)+i;

        System.out.println(str);
        return str;

    }

    /**
     * 找到a+bi的b
     * @param x 输入的字符串
     * @return b的整型
     */
    public int find(String x){
        String temp = "";
        if (x.contains("-")&&x.indexOf("-")!=0){
            for (int i = x.lastIndexOf("-")+1; i < x.length()-1; i++) {
                temp += String.valueOf(x.charAt(i));
            }
            temp = "-"+temp;
        }else {
            for (int i = x.indexOf("+")+1; i < x.length()-1; i++) {
                temp += String.valueOf(x.charAt(i));
            }
        }

        return Integer.parseInt(temp);
    }

    public int findOne(String x){
        String temp = "";
        if (x.charAt(0)=='-') {
            for (int i = 1; i < x.indexOf("+"); i++) {
                temp += x.charAt(i);
            }
            temp = "-" + temp;
        }else {
            for (int i = 0; i < x.indexOf("+"); i++) {
                temp += x.charAt(i);
            }
        }
        return Integer.parseInt(String.valueOf(temp));
    }

    public static void main(String[] args) {
        ComplexNumber complexNumber = new ComplexNumber();
        String a = "78+-76i";
        String b = "-86+72i";
        complexNumber.complexNumberMultiply(a,b);
    }
}
