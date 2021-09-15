
//        IMPORTS
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//  problem #669 -> https://leetcode.com/problems/trim-a-binary-search-tree/

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
  private int low, high;

  public TreeNode trimBST(TreeNode root, int low, int high) {
    this.low = low;
    this.high = high;
    root = helper(root);
    return root;
  }

  private TreeNode helper(TreeNode root) {
    if (root == null)
      return null;
    if (root.val < low)
      return helper(root.right);
    if (root.val > high)
      return helper(root.left);
    root.left = helper(root.left);
    root.right = helper(root.right);
    return root;
  }
}

// MAIN
public class TrimaBinarySearchTree {
  public static void main(String[] args) {
    Solution sol = new Solution();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(2);
    int low = 1;
    int high = 2;
    sol.trimBST(root, low, high);
    var li = new ArrayList<Integer>();
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null)
      q.add(root);
    while (!q.isEmpty()) {
      var node = q.poll();
      li.add(node.val);
      if (node.left != null)
        q.add(node.left);
      if (node.right != null)
        q.add(node.right);
    }
    System.out.println(li);
  }
}
