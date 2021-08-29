
//        IMPORTS
import java.util.Scanner;

//  problem #33 -> https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
  private boolean inRange(int x, int l, int r) {
    return l <= x && x <= r;
  }

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[left] <= nums[mid]) {
        if (inRange(target, nums[left], nums[mid])) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (inRange(target, nums[mid], nums[right])) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}

// MAIN
public class SearchinRotatedSortedArray {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // length of array
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int target = sc.nextInt();
    sc.close();
    System.out.print(sol.search(nums, target));
  }
}