package Leetcode.BinaryTrees;

/**
 * 101. 对称二叉树
 */
public class SymmetricTree {
    public boolean isSymmetrical(TreeNode root){
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }


    private boolean isMirror(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        //左子树的左子树和右子树的右子树相等且左子树的右子树和右子树的左子树相等
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
