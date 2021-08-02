
//        IMPORTS
import java.util.Scanner;

//  problem #605 -> https://leetcode.com/problems/can-place-flowers/

class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int len = flowerbed.length;
    int count = 0;
    for (int i = 0; i < len; i++) {
      if (flowerbed[i] == 1)
        continue;
      if (((i == 0) || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
        flowerbed[i] = 1;
        count++;
      }
    }
    return count >= n;
  }
}

// MAIN
public class CanPlaceFlowers {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int len = sc.nextInt();
    int flowerbed[] = new int[len];
    for (int i = 0; i < len; i++)
      flowerbed[i] = sc.nextInt();
    int n = sc.nextInt();
    sc.close();
    System.out.println(sol.canPlaceFlowers(flowerbed, n));
  }
}
