//        IMPORTS
//  problem #112 -> https://leetcode.com/problems/path-sum/

class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return helper(root, targetSum);
  }

  private boolean helper(TreeNode root, int target) {
    if (root == null)
      return false;
    target -= root.val;
    if (root.right == null && root.left == null) {
      return (target == 0);
    }
    return (helper(root.right, target) || helper(root.left, target));
  }
}

public class PathSum {

}
