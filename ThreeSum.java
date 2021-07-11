//        IMPORTS
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// problem 15 -> https://leetcode.com/problems/3sum/

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    int n = nums.length;
    for(int i=0;i<n;i++){
      int a = nums[i];
      int l = i+1 , h = n-1 ;
      if(i > 0 && nums[i] == nums[i-1]) continue;
      while(l < h){
        int b = nums[l] , c = nums[h];
        if(a == -(b + c)){
          List<Integer> temp = new ArrayList<Integer>();
          temp.add(a);  temp.add(b) ; temp.add(c);
          res.add(temp);
          while(l < h && nums[l] == nums[l+1])  l++;
          while(l < h && nums[h] == nums[h-1]) h--;
          l++; h--;
        }
        else if(a > (0 -b -c))  h--;
        else l++;
      }
    }
    return res;
  }
}

//        MAIN

public class ThreeSum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for(int i=0;i<n;i++)
      nums[i] = sc.nextInt();
    sc.close();
    List<List<Integer>> res = sol.threeSum(nums);
    for(int i=0;i<res.size();i++){
      System.out.println(res.get(i));
    }
  }
}
