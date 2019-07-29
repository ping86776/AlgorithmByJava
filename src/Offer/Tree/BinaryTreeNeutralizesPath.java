package Offer.Tree;

import Leetcode.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  二叉树中和为某一值的路径
 */
public class BinaryTreeNeutralizesPath {
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) return res;

        target -= root.val;
        temp.add(root.val);
        //当前结点不是叶结点则递归左右子树
        if(target == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(temp));
        else{
            FindPath(root.left, target);
            FindPath(root.right, target);
        }
        //搜索完一棵子树，需要回到上一个父节点
        temp.remove(temp.size()-1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);

        BinaryTreeNeutralizesPath.FindPath(node, 5);
        System.out.println(res);
    }
}
