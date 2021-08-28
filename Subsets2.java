
//        IMPORTS
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  problem #90 -> https://leetcode.com/problems/subsets-ii/

class Solution {
  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    helper(0, nums, new ArrayList<>(), false);
    return res;
  }

  private void helper(int i, int nums[], List<Integer> curr, boolean isIncluded) {
    if (i == nums.length) {
      res.add(new ArrayList<>(curr));
      return;
    }
    helper(i + 1, nums, curr, false);
    if (i > 0 && nums[i - 1] == nums[i] && isIncluded == false)
      return;
    curr.add(nums[i]);
    helper(i + 1, nums, curr, true);
    curr.remove(curr.size() - 1);
  }
}

// MAIN
public class Subsets2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    List<List<Integer>> subsets = sol.subsetsWithDup(nums);
    System.out.println(subsets);
  }
}
