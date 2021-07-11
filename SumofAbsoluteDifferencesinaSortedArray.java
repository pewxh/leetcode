//        IMPORTS
import java.util.Scanner;

// problem #1685 -> https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int pre[] , suf[] , res[];
        pre = new int[n];
        suf = new int[n];
        res = new int[n];
        pre[0] = nums[0];
        suf[n-1] = nums[n-1];
        for(int i=1;i<n;i++)
            pre[i] = pre[i-1] + nums[i];
        for(int i=n-2;i>=0;i--)
            suf[i] = nums[i] + suf[i+1];
        for(int i=0;i<n;i++)
            res[i] = ((nums[i]*i) - pre[i]) + (suf[i] - (nums[i]*(n-1-i)));
        return res;
    }
}

//        MAIN

public class SumofAbsoluteDifferencesinaSortedArray {
  public static void main(String[] args) {
  Solution sol = new Solution();
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int nums[] = new int[n];
  for(int i=0;i<n;i++)
    nums[i] = sc.nextInt();
  sc.close();
  int res[] = sol.getSumAbsoluteDifferences(nums);
  for(int i=0;i<n;i++)
    System.out.print(res[i]+" ");
  }
}
