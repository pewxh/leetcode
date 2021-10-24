
//        IMPORTS
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  problem #508 -> https://leetcode.com/problems/most-frequent-subtree-sum/

public class Solution {
  private Map<Integer, Integer> freq;
  private int max_freq = 0;

  public int[] findFrequentTreeSum(TreeNode root) {
    freq = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    dfs(root);
    freq.forEach((k, v) -> {
      if (v == max_freq)
        ans.add(k);
    });
    return ans.stream().mapToInt(i -> i).toArray();
  }

  private int dfs(TreeNode root) {
    if (root == null)
      return 0;
    int _sum = root.val + dfs(root.left) + dfs(root.right);
    freq.put(_sum, freq.getOrDefault(_sum, 0) + 1);
    max_freq = Math.max(max_freq, freq.get(_sum));
    return _sum;
  }
}

// MAIN
class MostFrequentSubtreeSum {

}
