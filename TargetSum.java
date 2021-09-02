
//        IMPORTS
import java.util.Scanner;
import java.util.stream.IntStream;

//  problem #494 -> https://leetcode.com/problems/target-sum/

class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    int sum = IntStream.of(nums).sum();
    if ((sum + target) % 2 != 0 || target > sum || target < -sum)
      return 0;
    int s1 = (sum + target) / 2;
    return countSubset(nums, s1);
  }

  private int countSubset(int[] nums, int w) {
    int n = nums.length;
    int memo[][] = new int[n + 1][w + 1];
    memo[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= w; j++) {
        if (nums[i - 1] <= j) {
          memo[i][j] = memo[i - 1][j] + memo[i - 1][j - nums[i - 1]];
        } else {
          memo[i][j] = memo[i - 1][j];
        }
      }
    }
    return memo[n][w];
  }
}

// MAIN
public class TargetSum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int target = sc.nextInt();
    sc.close();
    System.out.print(sol.findTargetSumWays(nums, target));
  }
}
