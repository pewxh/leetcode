
//        IMPORTS
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//  problem #128 -> https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
  public int longestConsecutive(int[] nums) {
    int mx = 0;
    Set<Integer> mp = new HashSet<Integer>(); // java equivalent of unordered_map
    for (int num : nums)
      mp.add(num);
    for (int num : nums) {
      if (mp.contains(num - 1))
        continue;
      int curr = 1;
      while (mp.contains(num + curr))
        curr++;
      mx = Math.max(mx, curr);
    }
    return mx;
  }
}

// MAIN
public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.print(sol.longestConsecutive(nums));
  }
}
