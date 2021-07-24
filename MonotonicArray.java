//        IMPORTS
import java.util.Scanner;

//  problem #896 -> https://leetcode.com/problems/monotonic-array/

class Solution {
  public boolean isMonotonic(int[] nums) {
    boolean isNonIncreasing = true, isNonDecreasing = true;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1])
        isNonIncreasing = false;
      else if (nums[i] < nums[i - 1])
        isNonDecreasing = false;
    }
    return isNonIncreasing || isNonDecreasing;
  }
}

//        MAIN
public class MonotonicArray {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for(int i=0;i<n;i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.isMonotonic(nums));
  }
}
