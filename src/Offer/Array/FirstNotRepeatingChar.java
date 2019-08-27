package Offer.Array;


public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
        //因为char字符是由8位组成，所以数组最大是256个(英文字母的话127完整的ASCII码256个)
        //char哈希表的形式来映射关系
        int[] res = new int[256];
        for (int i = 0; i < str.length(); i++) {
            if (res[str.charAt(i)] == 0) {
                res[str.charAt(i)] = 1;
            } else {
                res[str.charAt(i)] += 1;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (res[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String str = "google";
        System.out.println((int) str.charAt(4));
        System.out.println(FirstNotRepeatingChar.firstNotRepeatingChar(str));
    }
}
