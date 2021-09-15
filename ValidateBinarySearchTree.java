//        IMPORTS

//  problem #98 -> https://leetcode.com/problems/validate-binary-search-tree/

//  NOTE :- *COMMENT THE TREENODE CLASS BEFORE SUBMITTING THIS CODE IN LEETCODE*
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  public boolean isValidBST(TreeNode root) {
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean helper(TreeNode root, long min, long max) {
    if (root == null)
      return true;
    if (root.val <= min || root.val >= max)
      return false;
    return helper(root.left, min, root.val) && helper(root.right, root.val, max);
  }
}

// MAIN
public class ValidateBinarySearchTree {
  public static void main(String[] args) {
    Solution sol = new Solution();
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    System.out.println(sol.isValidBST(root));
  }
}