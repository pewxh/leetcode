
//        IMPORTS
import java.util.Scanner;

//  problem #485 -> https://leetcode.com/problems/max-consecutive-ones/

class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int res = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int curr = 0;
      while (i < n && nums[i] == 1) {
        curr++;
        i++;
      }
      res = Math.max(curr, res);
    }
    return res;
  }
}

// MAIN
public class MaxConsecutiveOnes {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.print(sol.findMaxConsecutiveOnes(nums));
  }
}
