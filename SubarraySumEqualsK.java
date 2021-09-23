
//        IMPORTS
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//  problem #560 -> https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> mp = new HashMap<>();
    int prefixSum = 0;
    int count = 0;
    mp.put(0, 1); // initially we have 1 subarray, whose count is 0 (i.e {null})
    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i]; // sum of all the elements till i'th position
      count += mp.getOrDefault(prefixSum - k, 0);
      mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
  }
}

// MAIN
public class SubarraySumEqualsK {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int k = sc.nextInt();
    sc.close();
    System.out.print(sol.subarraySum(nums, k));
  }
}
