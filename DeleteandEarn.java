
//        IMPORTS
import java.util.Scanner;

//  problem #740 -> https://leetcode.com/problems/delete-and-earn/

class Solution {
  private int freq[];
  private Integer[] memo;

  public int deleteAndEarn(int[] nums) {
    int MAX = (int) 1e5;
    freq = new int[MAX];
    this.memo = new Integer[MAX];
    for (int it : nums)
      freq[it]++;
    return helper(MAX - 1);
  }

  private int helper(int n) {
    if (n < 1)
      return 0;
    if (n == 1)
      return freq[1];
    if (n == 2)
      return (Math.max(freq[1], 2 * freq[2]));
    if (memo[n] != null)
      return memo[n];
    int inc = (freq[n] * n) + helper(n - 2);
    int exc = helper(n - 1);
    return memo[n] = Math.max(inc, exc);
  }
}

// MAIN
public class DeleteandEarn {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.print(sol.deleteAndEarn(nums));
  }
}
