//        IMPORTS
import java.util.Scanner;

// problem #136 -> https://leetcode.com/problems/single-number/

class Solution {
  public int SingleNumber(int[] nums){
    int xor = 0;
    for(int i:nums)
      xor ^= i;
    return xor;
  }
}
//        MAIN
public class SingleNumber {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); 
    int[] nums = new int[n];
    for(int i=0;i<n;i++)
      nums[i] = sc.nextInt();
    int uniqueNum = sol.SingleNumber(nums);
    System.out.println(uniqueNum);
 } 
}
