package Leetcode.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class BinaryTreePaths {
    public static void construct_paths(TreeNode root, String path, List<String> paths) {
        if (root == null) return;
        path += Integer.toString(root.val);
        if ((root.left == null) && (root.right == null))  // 当前节点是叶子节点
            paths.add(path);  // 把路径加入到答案中
        else {
            path += "->";  // 当前节点不是叶子节点，继续递归遍历
            construct_paths(root.left, path, paths);
            construct_paths(root.right, path, paths);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        construct_paths(root, "", paths);
        return paths;
    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);

        List<String> list = BinaryTreePaths.binaryTreePaths(node);
        System.out.println(list);

    }

}
