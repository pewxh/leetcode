
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

//  problem #217 -> https://leetcode.com/problems/contains-duplicate/

class Solution {
  public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1])
        return true;
    }
    return false;
  }
}

// MAIN
public class ContainsDuplicate {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.containsDuplicate(nums));
  }
}
