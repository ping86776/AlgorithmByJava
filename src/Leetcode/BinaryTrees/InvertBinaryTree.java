package Leetcode.BinaryTrees;


/**
 * 226. Invert Binary Tree 反转二叉树
 */
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return null;
        //前序
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null){
            invertTree(root.left);
        }
        if (root.right != null){
            invertTree(root.right);
        }

        return root;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);

        TreeNode p = InvertBinaryTree.invertTree(node);
        System.out.println(p);

    }
}
