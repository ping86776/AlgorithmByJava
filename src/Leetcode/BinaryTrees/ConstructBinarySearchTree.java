package Leetcode.BinaryTrees;

/**
 * Construct Binary Search Tree from Preorder Traversal 先序遍历二叉树
 */

public class ConstructBinarySearchTree {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode treeNode = new TreeNode(preorder[0]);  //初始化数，第一个数位根节点
        for (int i = 0; i < preorder.length; i++) {
            createTree(treeNode,preorder[i]);
        }
        return treeNode;
    }

    public void createTree(TreeNode treeNode, int Currentnode){
        if (treeNode.val < Currentnode){
            //当前节点比根节点大,递归放右边，如果右节点值为null,则新建为当前节点
            if (treeNode.right==null){
                treeNode.right = new TreeNode(Currentnode);
            }else {
                createTree(treeNode.right, Currentnode);
            }
        }else if (treeNode.val > Currentnode){
            if (treeNode.left == null){
                treeNode.left = new TreeNode(Currentnode);
            }else {
                createTree(treeNode.left, Currentnode);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,5,1,7,10,12};
        ConstructBinarySearchTree c = new ConstructBinarySearchTree();
        c.bstFromPreorder(arr);

    }
}
