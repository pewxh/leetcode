
//				IMPORTS
import java.util.Scanner;

// problem #213 -> https://leetcode.com/problems/house-robber-ii/

class Solution {
  public int rob(int[] nums) {
    int n = nums.length;
    if (n < 2)
      return nums[0];
    if (n == 2)
      return Math.max(nums[0], nums[1]);
    int max_including_first_house = Math.max(nums[0], nums[1]);
    int max_excluding_first_house = Math.max(nums[1], nums[2]);
    int max_excluding_prev_house = nums[0];
    for (int i = 2; i < n - 1; i++) {
      int curr_max = Math.max(max_excluding_prev_house + nums[i], max_including_first_house);
      max_excluding_prev_house = max_including_first_house;
      max_including_first_house = curr_max;
    }
    max_excluding_prev_house = nums[1];
    for (int i = 3; i < n; i++) {
      int curr_max = Math.max(max_excluding_prev_house + nums[i], max_excluding_first_house);
      max_excluding_prev_house = max_excluding_first_house;
      max_excluding_first_house = curr_max;
    }
    return Math.max(max_excluding_first_house, max_including_first_house);
  }
}

// MAIN
public class HouseRobber2 {
  public static void main(String[] args) {
    int n; // number of houses
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.print(sol.rob(nums));
  }
}
