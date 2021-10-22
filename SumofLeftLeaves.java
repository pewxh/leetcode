//        IMPORTS

//  problem #404 -> https://leetcode.com/problems/sum-of-left-leaves/

class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    return helper(root, false);
  }

  private int helper(TreeNode root, boolean isLeft) {
    if (root == null)
      return 0;
    if (isLeft && root.left == null && root.right == null)
      return root.val;
    return helper(root.left, true) + helper(root.right, false);
  }
}

// MAIN
public class SumofLeftLeaves {

}
