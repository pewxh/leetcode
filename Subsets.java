
//        IMPORTS
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//  problem #78 -> https://leetcode.com/problems/subsets/

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < Math.pow(2, n); i++) {
      String bitmask = String.format("%10s", Integer.toBinaryString(i)).replace(' ', '0');
      List<Integer> curr = new ArrayList<Integer>();
      for (int j = 0; j < n; j++) {
        if (bitmask.charAt(9 - j) == '1')
          curr.add(nums[j]);
      }
      res.add(curr);
    }
    return res;
  }
}

// MAIN
public class Subsets {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    List<List<Integer>> subsets = sol.subsets(nums);
    System.out.println(subsets);
  }
}
