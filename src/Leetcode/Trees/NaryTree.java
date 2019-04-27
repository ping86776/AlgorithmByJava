package Leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal 给定一个 N 叉树，返回其节点值的后序遍历。
 */

public class NaryTree {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {

        if(root==null) return null;

        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        list.add(root.val);
        return list;
    }
}
