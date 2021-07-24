//        IMPORTS
import java.util.Scanner;

//  problem #75 -> https://leetcode.com/problems/sort-colors/

class Solution {
  private void swap(int[] nums,int p1,int p2){
    int t = nums[p1];
    nums[p1] = nums[p2];
    nums[p2] = t;
  }
  public void sortColors(int[] nums){
    int n = nums.length;
    int first = 0 , second = 0 , third = n-1;
    while(second <= third){
      switch(nums[second]){
        case 0:
          swap(nums,first,second);
          first++;  second++;
          break;
        case 1:
          second++;
          break;
        case 2:
          swap(nums,second,third);
          third--;
      }
    }
  }
}

//        MAIN
public class SortColors {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for(int i=0;i<n;i++)
      nums[i] = sc.nextInt();
    sc.close();
    sol.sortColors(nums);
    for(int i=0;i<n;i++)
      System.out.print(nums[i] + " ");  
  }
}
