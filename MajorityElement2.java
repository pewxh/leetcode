
//        IMPORTS
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  problem #229 -> https://leetcode.com/problems/majority-element-ii/

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    // Moore's Voting Algo Extension
    int count[] = { 0, 0 };
    int possibleRes[] = { 0, 0 };
    for (int num : nums) {
      if (possibleRes[0] == num)
        count[0]++;
      else if (possibleRes[1] == num)
        count[1]++;
      else if (count[0] == 0) {
        possibleRes[0] = num;
        count[0]++;
      } else if (count[1] == 0) {
        possibleRes[1] = num;
        count[1]++;
      } else {
        count[0]--;
        count[1]--;
      }

    }
    List<Integer> res = new ArrayList<>();
    count[0] = count[1] = 0;
    for (int num : nums) {
      if (possibleRes[0] == num)
        count[0]++;
      else if (possibleRes[1] == num)
        count[1]++;
    }
    if (count[0] > nums.length / 3)
      res.add(possibleRes[0]);
    if (count[1] > nums.length / 3)
      res.add(possibleRes[1]);
    return res;
  }
}

// MAIN
public class MajorityElement2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    List<Integer> majorityElement = sol.majorityElement(nums);
    System.out.print(majorityElement);
  }
}
