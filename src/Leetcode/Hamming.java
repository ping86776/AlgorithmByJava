package Leetcode;

public class Hamming {
    public int hammingDistance(int x, int y) {
        String a = Integer.toBinaryString(x^y);
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i)=='1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Hamming hamming = new Hamming();
        System.out.println(hamming.hammingDistance(1,3));
    }
}
