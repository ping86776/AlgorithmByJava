package Offer.Tree;

import Leetcode.BinaryTrees.TreeNode;

import java.util.LinkedList;

/**
 * 序列化反序列化二叉树
 */
public class SerializeandDeserializeBST {
    //序列化
    public static String Serialize(TreeNode root) {
        if (root == null) return "#,";

        StringBuffer sb = new StringBuffer(root.val + ",");

        //前序遍历
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));

        return sb.toString();
    }

    //反序列化
    public static TreeNode Deserialize(String str) {
        String[] res = str.split(",");

        LinkedList<String> queue = new LinkedList<>();

        for (int i = 0; i < res.length; i++) {
            queue.offer(res[i]);
        }

        return rebuild(queue);
    }

    //重建二叉树
    public static TreeNode rebuild(LinkedList<String> queue) {
        if (queue.isEmpty()) return null;

        String val = queue.poll();
        if(val.equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = rebuild(queue);
        root.right = rebuild(queue);

        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.right = new TreeNode(6);
        node.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.left.left = new TreeNode(2);
        node.left.left.left = new TreeNode(1);

        String se = SerializeandDeserializeBST.Serialize(node);
        TreeNode p = SerializeandDeserializeBST.Deserialize(se);
        System.out.println(se);
        System.out.println(p);
    }
}
