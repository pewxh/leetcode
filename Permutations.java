
//        IMPORTS
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  problem #46 -> https://leetcode.com/problems/permutations/

class Solution {
  private int nums[];
  private List<List<Integer>> res;

  public List<List<Integer>> permute(int[] nums) {
    res = new ArrayList<>();
    this.nums = nums;
    helper(0);
    return res;
  }

  private void helper(int n) {
    if (n == nums.length) {
      List<Integer> cur = new ArrayList<>();
      for (int it : nums)
        cur.add(it);
      res.add(cur);
      return;
    }
    for (int i = n; i < nums.length; i++) {
      swap(n, i);
      helper(n + 1);
      swap(n, i);
    }
  }

  private void swap(int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

// MAIN
public class Permutations {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.permute(nums));
  }
}
