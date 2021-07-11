//        IMPORTS
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// problem #56 -> https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res_list = new ArrayList<>();
        // int temp[] = new int[1];
        // temp[0] = intervals[0][0];  temp[1] = intervals[0][1];
        int temp[] = intervals[0];
        for(int i=1;i<intervals.length;i++){
          if(temp[1] >= intervals[i][0])
            temp[1] = Math.max(temp[1],intervals[i][1]);
          else{
            res_list.add(temp);
            temp = intervals[i];
          }
        }
        res_list.add(temp);
        int res[][] = res_list.toArray(new int[res_list.size()][2]);
        return res;
    }
}

//        MAIN
public class MergeIntervals {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // number of intervals
    int intervals[][] = new int[n][2];
    for(int i=0;i<n;i++){
      intervals[i][0] = sc.nextInt();
      intervals[i][1] = sc.nextInt();
    }
    int res[][] = sol.merge(intervals);
    for(int i=0;i<res.length;i++)
      System.out.println(res[i][0] + " , " + res[i][1] );

  }  
}
