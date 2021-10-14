
//        IMPORTS
import java.util.Scanner;

//  problem #11 -> https://leetcode.com/problems/container-with-most-water/

class Solution {
  public int maxArea(int[] height) {
    int lo = 0;
    int ans = 0;
    int hi = height.length - 1;
    while (lo < hi) {
      int cur = Math.min(height[lo], height[hi]) * (hi - lo);
      ans = Math.max(ans, cur);
      if (height[lo] < height[hi])
        lo++;
      else
        hi--;
    }
    return ans;
  }
}

// MAIN
public class ContainerWithMostWater {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int height[] = new int[n];
    for (int i = 0; i < n; i++)
      height[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.maxArea(height));
  }
}
