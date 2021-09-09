
//        IMPORTS
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  problem #39 -> https://leetcode.com/problems/combination-sum/

class Solution {
  private List<List<Integer>> res;
  private int[] candidates;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    res = new ArrayList<>();
    this.candidates = candidates;
    helper(candidates.length, target, new ArrayList<>());
    return res;
  }

  private void helper(int n, int target, List<Integer> curr) {
    if (n == 0)
      return;
    if (target == 0) {
      res.add(new ArrayList<>(curr));
      return;
    }
    if (candidates[n - 1] <= target) {
      curr.add(candidates[n - 1]);
      helper(n, target - candidates[n - 1], curr);
      curr.remove(curr.size() - 1);
    }
    helper(n - 1, target, curr);
  }
}

// MAIN
public class CombinationSum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int candidates[] = new int[n];
    for (int i = 0; i < n; i++)
      candidates[i] = sc.nextInt();
    int target = sc.nextInt();
    sc.close();
    System.out.print(sol.combinationSum(candidates, target));
  }
}
