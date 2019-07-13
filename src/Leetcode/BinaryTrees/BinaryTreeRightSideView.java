package Leetcode.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 */
public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;

        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {    //由于在循环内出队列，所以最后没子节点后队列一定是空的
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                if (i == size - 1){ //只添加队列里最后一个
                    res.add(node.val);
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(4);

        BinaryTreeRightSideView.rightSideView(node);



    }
}
