
//        IMPORTS
import java.util.Scanner;

//  problem #724 -> https://leetcode.com/problems/find-pivot-index/

class Solution {
  public int pivotIndex(int[] nums) {
    int n = nums.length;
    int leftSum[] = new int[n];
    int rightSum[] = new int[n];
    leftSum[0] = nums[0];
    rightSum[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      leftSum[i] = leftSum[i - 1] + nums[i];
      rightSum[n - 1 - i] = rightSum[n - i] + nums[n - 1 - i];
    }
    for (int i = 0; i < n; i++) {
      if (leftSum[i] == rightSum[i])
        return i;
    }
    return -1;
  }
}

// MAIN
public class FindPivotIndex {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.pivotIndex(nums));
  }
}
