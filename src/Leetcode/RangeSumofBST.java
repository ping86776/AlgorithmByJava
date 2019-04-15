package Leetcode;

/**
 * 938. Range Sum of BST Created by Ping on 2019/4/15.
 * 求符合 L <= val <= R 的所有节点的总和，即例子 1 中 32 = 7 + 10 + 15，值为10的结点是处于L和R之间的结点；
 * 二叉搜索树的特点为：若左子树不为空, 则左子树的所有结点都小于根节点; 若右子树不为空, 则右子树的所有结点都大于根节点。
 */
public class RangeSumofBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val >= L && root.val <= R){
            //若该结点的值 val 处于 L 和 R 之间，则将该值加起来
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }else if(root.val < L){
            //若 val < L，根据二叉搜索树的特点，该结点的右边可能存在符号条件的值，继续搜寻该结点的右边
            return rangeSumBST(root.right, L, R);
        }else {
            //若 val > R，该结点的左边可能存在符号条件的值，继续搜寻该结点的左边。
            return rangeSumBST(root.left, L, R);
        }
    }
}
