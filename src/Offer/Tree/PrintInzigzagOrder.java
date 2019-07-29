package Offer.Tree;

import Leetcode.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 按之字形顺序打印二叉树
 * 设两个栈，s2存放奇数层，s1存放偶数层
 * 遍历s2节点的同时按照左子树、右子树的顺序加入s1，
 * 遍历s1节点的同时按照右子树、左子树的顺序加入s2
 */
public class PrintInzigzagOrder {
    public static List<List<Integer>> print(TreeNode root) {
        if (root == null) return null;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack2.push(root);
        //判断层数
        int flag = 1;

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            //奇数列
            if ((flag & 1) == 1){
                while (!stack2.isEmpty()) {
                   TreeNode node = stack2.pop();
                   temp.add(node.val);
                   //左子树、右子树的顺序
                   if (node.left != null) {
                       stack1.push(node.left);
                   }
                   if (node.right != null) {
                       stack1.push(node.right);
                   }
                }
            }
            //偶数列
            if ((flag & 1) == 0) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    //右子树、左子树的顺序
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                }
            }

            res.add(new ArrayList<>(temp));
            temp.clear();
            flag++;
        }

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

        List<List<Integer>> res = PrintInzigzagOrder.print(node);
        System.out.println(res);
    }
}
