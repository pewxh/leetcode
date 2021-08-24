
//        IMPORTS
import java.util.Scanner;

//  problem #26 -> https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n == 0)
      return 0;
    int k = 1;
    for (int i = 1; i < n; i++) {
      if (nums[k - 1] != nums[i])
        nums[k++] = nums[i];
    }
    return k;
  }
}

// MAIN
public class RemoveDuplicatesfromSortedArray {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    int k = sol.removeDuplicates(nums);
    for (int i = 0; i < k; i++)
      System.out.print(nums[i] + " ");
  }
}
