package Leetcode.BinaryTrees;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
    返回二叉搜索树公共祖先
   Created by Ping on 2019/4/30.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root比q p节点要大，根据二叉搜索树的性质，往左找
        if(root.val>p.val&&root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        //root比q p节点要小，根据二叉搜索树的性质，往右找
        if(root.val<p.val&&root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        //介于二者之间或者正好等于q 则正好是公共祖先
        return root;
    }
}
