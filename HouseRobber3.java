//        IMPORTS
//  problem #337 -> https://leetcode.com/problems/house-robber-iii/

class Solution {
  private Map<TreeNode, Integer> memo = new HashMap<>();

  public int rob(TreeNode root) {
    return helper(root);
  }

  private int helper(TreeNode root) {
    if (root == null)
      return 0;
    if (memo.containsKey(root))
      return memo.get(root);
    int exc = helper(root.left) + helper(root.right);
    var leftChild = root.left;
    var rightChild = root.right;
    int inc = root.val + ((leftChild != null) ? helper(leftChild.left) + helper(leftChild.right) : 0)
        + ((rightChild != null) ? helper(rightChild.left) + helper(rightChild.right) : 0);

    int res = Math.max(inc, exc);
    memo.put(root, res);
    return res;
  }
}

// MAIN
public class HouseRobber3 {

}
