
//        IMPORTS
import java.util.Scanner;

//  problem #287 -> https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
  public int findDuplicate(int[] nums) {
    int fast = nums[0], slow = nums[0];
    do {
      fast = nums[fast];
      fast = nums[fast];
      slow = nums[slow];
    } while (fast != slow);
    fast = nums[0];
    while (fast != slow) {
      fast = nums[fast];
      slow = nums[slow];
    }
    return fast;
  }
}

// MAIN
public class FindtheDuplicateNumber {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    int duplicate = sol.findDuplicate(nums);
    System.out.println(duplicate);
  }
}
