
//        IMPORTS
import java.util.Scanner;

//  problem #134 -> https://leetcode.com/problems/gas-station/

class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0;
    int gasLeft = 0;
    int totalGas = 0;
    int totalCost = 0;
    for (int i = 0; i < gas.length; i++) {
      gasLeft += gas[i] - cost[i];
      if (gasLeft < 0) {
        start = i + 1; // just move on and hope you find the answer at index i+1
        gasLeft = 0;
      }
      totalGas += gas[i];
      totalCost += cost[i];
    }
    start = (totalCost > totalGas) ? -1 : start;
    // if totalcost is higher than total gas, you wont find any suitable answer
    return start;
  }
}

// MAIN
public class GasStation {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int gas[] = new int[n];
    int cost[] = new int[n];
    for (int i = 0; i < n; i++)
      gas[i] = sc.nextInt();
    for (int i = 0; i < n; i++)
      cost[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.canCompleteCircuit(gas, cost));
  }
}
