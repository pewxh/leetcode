
//        IMPORTS
import java.util.ArrayList;
import java.util.List;

//  problem #102 -> https://leetcode.com/problems/binary-tree-level-order-traversal/

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
  private List<List<Integer>> res;

  public List<List<Integer>> levelOrder(TreeNode root) {
    res = new ArrayList<>();
    int height = height(root);
    for (int i = 0; i < height; i++)
      res.add(new ArrayList<>());
    helper(root, 0);
    return res;
  }

  private int height(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + Math.max(height(root.left), height(root.right));
  }

  private void helper(TreeNode root, int level) {
    if (root == null)
      return;
    res.get(level).add(root.val);
    helper(root.left, level + 1);
    helper(root.right, level + 1);
  }
}

// MAIN
public class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    Solution sol = new Solution();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(2);
    System.out.println(sol.levelOrder(root));
  }
}
