//        IMPORTS
//  problem #113 -> https://leetcode.com/problems/path-sum-ii/

class Solution {
  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    helper(root, new ArrayList<>(), targetSum);
    return res;
  }

  private void helper(TreeNode root, List<Integer> curr, int target) {
    if (root == null) {
      return;
    }
    curr.add(root.val);
    target -= root.val;
    if (root.left == null && root.right == null) {
      if (target == 0)
        res.add(new ArrayList<>(curr));
    }
    helper(root.left, curr, target);
    helper(root.right, curr, target);
    curr.remove(curr.size() - 1);
  }
}

public class PathSum2 {

}
