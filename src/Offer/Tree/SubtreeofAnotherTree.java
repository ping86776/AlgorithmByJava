package Offer.Tree;

import Leetcode.BinaryTrees.TreeNode;

/**
 * 树的子结构
 */
public class SubtreeofAnotherTree {
    private static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t ==null) return true;
        if (s == null || t == null) return false;
        //三种情况，相等，t是s的左子树，t是s的右子树
        if (s.val == t.val){
            return isEquals(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        // 根节点不同，那么就不同考虑s和t相等的情形了
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 判断t和s是否相等
     * @param s
     * @param t
     * @return
     */
    private static boolean isEquals(TreeNode s, TreeNode t) {
        if (s == null && t ==null) return true;
        if (s == null || t == null) return false;

        if (s.val == t.val){
            return isEquals(s.left, t.left) && isEquals(s.right, t.right);
        }
        return false;
    }
}
