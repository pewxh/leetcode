//        IMPORTS

//  problem #236 -> https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

class Solution {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return helper(root, p, q);
  }

  private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;
    if (root.val == p.val || root.val == q.val)
      return root;
    var left = helper(root.left, p, q);
    var right = helper(root.right, p, q);
    if (left != null && right != null)
      return root;
    if (left == null)
      return right;
    return left;
  }
}

// MAIN
public class LowestCommonAncestorofaBinaryTree {

}
