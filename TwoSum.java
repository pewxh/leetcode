
//        IMPORTS
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// problem #1 -> https://leetcode.com/problems/two-sum/

class Solution {
  public int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    Map<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int candidate = target - nums[i];
      if (mp.containsKey(candidate))
        return new int[] { i, mp.get(candidate) };
      mp.put(nums[i], i);
    }
    return new int[] { -1, -1 }; // wont ever run
  }
}

// MAIN
public class TwoSum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int target = sc.nextInt();
    sc.close();
    int res[] = sol.twoSum(nums, target);
    System.out.println(res[0] + " " + res[1]);
  }
}
