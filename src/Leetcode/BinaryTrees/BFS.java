package Leetcode.BinaryTrees;

import java.util.LinkedList;

/**
 * 广度优先搜索(层次遍历队列实现) Created by Ping on 2019/4/28.
 */
public class BFS {
    public void Layertraversal(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            System.out.println(node.val);
            if (node.left!=null){
                queue.addLast(node.left);
            }
            if (node.right!=null){
                queue.addLast(node.right);
            }
        }
    }
}
