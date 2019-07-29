package Offer.Tree;

import Leetcode.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *把二叉树打印成多行
 * 思路: 层次遍历，设置两个状态变量来判断层数
 */
public class PrinteIntoMultipleLines {
    public static List<List<Integer>> print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int start = 0, end = 1;//根节点这层只有一个
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp.add(node.val);
            start++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            //利用start和end记录遍历的层数
            if (start == end) {
                res.add(temp);
                start = 0;
                temp = new ArrayList<>();
                end = queue.size();
            }
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

        List<List<Integer>> res = PrinteIntoMultipleLines.print(node);
        System.out.println(res);
    }
}
