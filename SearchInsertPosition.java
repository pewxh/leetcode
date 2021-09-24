
//        IMPORTS
import java.util.Scanner;

//  problem #35 -> https://leetcode.com/problems/search-insert-position/

class Solution {
  public int searchInsert(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo <= hi) {
      int mid = (lo) + (hi - lo) / 2;
      if (nums[mid] >= target) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }
}

// MAIN
public class SearchInsertPosition {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int target = sc.nextInt();
    System.out.println(sol.searchInsert(nums, target));
  }
}
