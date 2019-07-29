package Offer.Tree;

import Leetcode.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 */
public class KthSmallestElementinBST {
    //这里是全部遍历了一遍，效率较低
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node!=null){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }

        return res.get(k-1);
    }

    //提前终止，可以减少遍历次数
    private static int val;
    private static int k;
    public static int kthSmallest2(TreeNode root, int k) {
        KthSmallestElementinBST.k = k;
        inOrder(root);
        return val;
    }

    private static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        k--;
        //输出最左子树
        if(k == 0){
            KthSmallestElementinBST.val = root.val;
            return;
        }
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.right = new TreeNode(6);
        node.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.left.left = new TreeNode(2);
        node.left.left.left = new TreeNode(1);

        int value = KthSmallestElementinBST.kthSmallest2(node,3);
        System.out.println(value);
    }
}
