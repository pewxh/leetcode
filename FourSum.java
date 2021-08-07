
//        IMPORTS
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// problem 18 -> https://leetcode.com/problems/4sum/

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();// contains quad, p,q,r and s. i.e p+q+r+s = target
    int n = nums.length;
    if (n < 4)
      return res;
    Arrays.sort(nums);
    for (int i = 0; i < n; i++) {
      int p = nums[i]; // p
      for (int j = i + 1; j < n; j++) {
        int q = nums[j]; // q
        int req = target - (p + q);
        int left = j + 1;
        int right = n - 1;
        while (left < right) {
          int r = nums[left]; // r
          int s = nums[right]; // s
          if (req == r + s) {
            List<Integer> temp = new ArrayList<>();
            temp.add(p);
            temp.add(q);
            temp.add(r);
            temp.add(s);
            res.add(temp);
            while (left < right && nums[left] == r)
              left++;
            // skipping duplicate 'r'
            while (left < right && nums[right] == s)
              right--;
            // skipping duplicate 's'
          } else if (req > r + s)
            left++;
          else
            right--;

        }
        while (j < n - 1 && nums[j + 1] == q)
          j++;
        // skipping duplicate 'q'
      }
      while (i < n - 1 && nums[i + 1] == p)
        i++;
      // skipping duplicate 'p'
    }
    return res;
  }
}

// MAIN

public class FourSum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int target = sc.nextInt();
    sc.close();
    List<List<Integer>> res = sol.fourSum(nums, target);
    for (int i = 0; i < res.size(); i++) {
      System.out.println(res.get(i));
    }
  }
}
