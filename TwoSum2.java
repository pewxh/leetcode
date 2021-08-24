
//        IMPORTS
import java.util.Scanner;

//  problem #167 -> https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int curr = numbers[left] + numbers[right];
      if (curr == target)
        return new int[] { ++left, ++right };
      else if (curr < target)
        left++;
      else
        right--;
    }
    return new int[] { -1, -1 };
  }
}

// MAIN
public class TwoSum2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int target = sc.nextInt();
    sc.close();
    int res[] = sol.twoSum(nums, target);
    System.out.println(res[0] + " " + res[1]);
  }
}
