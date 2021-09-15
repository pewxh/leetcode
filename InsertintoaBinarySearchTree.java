
//        IMPORTS
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//  problem #701 -> https://leetcode.com/problems/insert-into-a-binary-search-tree/

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
  private int val;

  public TreeNode insertIntoBST(TreeNode root, int val) {
    this.val = val;
    return root = helper(root);
  }

  private TreeNode helper(TreeNode root) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (root.val > val) {
      root.left = helper(root.left);
    } else {
      root.right = helper(root.right);
    }
    return root;
  }
}

// MAIN
public class InsertintoaBinarySearchTree {
  public static void main(String[] args) {
    Solution sol = new Solution();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    int val = 5;
    sol.insertIntoBST(root, val);
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
