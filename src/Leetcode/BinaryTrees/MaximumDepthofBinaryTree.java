package Leetcode.BinaryTrees;

/**
 * 104. Maximum Depth of Binary Tree 二叉树最大深度
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);

        return ((leftdepth > rightdepth) ? leftdepth : rightdepth) + 1;
    }
}
