
//        IMPORTS
import java.util.Scanner;

//  problem #42 -> https://leetcode.com/problems/trapping-rain-water/

class Solution {
  public int trap(int[] height) {
    int res = 0;
    int n = height.length;
    int maxFromLeft[] = new int[n];
    int maxFromRight[] = new int[n];
    maxFromLeft[0] = height[0];
    maxFromRight[n - 1] = height[n - 1];
    for (int i = 1; i < n; i++)
      maxFromLeft[i] = Math.max(maxFromLeft[i - 1], height[i]);
    for (int i = n - 2; i > -1; i--)
      maxFromRight[i] = Math.max(maxFromRight[i + 1], height[i]);
    for (int i = 0; i < n; i++) {
      int waterCollectedInCurrentBlock = Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
      res += Math.max(waterCollectedInCurrentBlock, 0);
    }
    return res;
  }
}

// MAIN
public class TrappingRainWater {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int height[] = new int[n];
    for (int i = 0; i < n; i++)
      height[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.trap(height));
  }
}
