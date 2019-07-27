package Offer.Tree;

/**
 * 二叉搜索树的后序遍历序列
 */
public class VerifySquenceOfBST {
    public static boolean verifyBST(int [] sequence) {
        if (sequence.length == 0) return false;

        return verify(sequence, 0, sequence.length-1);
    }

    private static boolean verify(int[] sequence, int start, int end) {
        if (start >= end) return true;
        //根节点
        int root = sequence[end];

        //左节点小于根节点
        int i = 0;
        for (; i < end; i++) {
            if(sequence[i] > root){
                break;
            }
        }
        //右节点大于根节点
        for (int j = i; j < end; j++) {
            if (sequence[j] < root) return false;
        }

        //递归左子树
        boolean left = true;
        if (i > start) {
            left = verify(sequence, start, i-1);//子树最后一个数是根节点
        }
        //递归右子树
        boolean right = true;
        if (i < end) {
           right = verify(sequence, i, end-1);
        }

        return (left && right);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 6, 9, 11, 10, 8};
        boolean status = VerifySquenceOfBST.verifyBST(arr);
        System.out.println(status);
    }
}
