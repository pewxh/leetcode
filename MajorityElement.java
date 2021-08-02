
//        IMPORTS
import java.util.Scanner;

//  problem #169 -> https://leetcode.com/problems/majority-element/

class Solution {
  public int majorityElement(int[] nums) {
    // Moore's Voting Algo
    int count = 0;
    int possibleRes = 0;
    for (int i : nums) {
      if (count == 0)
        possibleRes = i;
      if (i == possibleRes)
        count++;
      else
        count--;
    }
    return possibleRes;
  }
}

// MAIN
public class MajorityElement {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    int majorityElement = sol.majorityElement(nums);
    System.out.print(majorityElement);
  }
}
