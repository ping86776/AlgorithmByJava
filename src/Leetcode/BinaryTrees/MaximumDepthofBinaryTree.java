package Leetcode.BinaryTrees;

/**
 * 104. Maximum Depth of Binary Tree 反转二叉树
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);

        return ((leftdepth > rightdepth) ? leftdepth : rightdepth) + 1;
    }
}
