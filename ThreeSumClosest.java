
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

// problem 16 -> https://leetcode.com/problems/3sum-closest/

class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int closest = Integer.MAX_VALUE - 1;
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < n; i++) {
      int a = nums[i];
      int lo = i + 1;
      int hi = n - 1;
      while (lo < hi) {
        int b = nums[lo];
        int c = nums[hi];
        int current = a + b + c;
        if (Math.abs(closest - target) > Math.abs(current - target))
          closest = current;
        if (current == target)
          return current;
        else if (current > target)
          hi--;
        else
          lo++;
      }
    }
    return closest;
  }
}

// MAIN

public class ThreeSumClosest {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int target = sc.nextInt();
    sc.close();
    System.out.print(sol.threeSumClosest(nums, target));
  }
}
