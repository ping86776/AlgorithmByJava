package Leetcode.BinaryTrees;

/**
 * 617. Merge Two Binary Trees 合并二叉树
 */

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
       if (t1==null) return t1;
       if (t2==null) return t2;

       t1.val += t2.val;

       t1.left = mergeTrees(t1.left, t2.left);
       t2.right = mergeTrees(t1.right, t2.right);

       return t1;

    }

}
