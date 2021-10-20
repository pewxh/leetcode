
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

//  problem #283 -> https://leetcode.com/problems/move-zeroes/

class Solution {
  public void moveZeroes(int[] nums) {
    int countNonZero = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        swap(nums, countNonZero, i);
        countNonZero++;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t; // t = 0
  }
}

// MAIN
public class MoveZeroes {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    sol.moveZeroes(nums);
    System.out.print(Arrays.toString(nums));
  }
}
