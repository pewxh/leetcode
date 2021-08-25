
//        IMPORTS
import java.util.Scanner;

//  problem #551 -> https://leetcode.com/problems/student-attendance-record-i/

class Solution {
  public boolean checkRecord(String s) {
    int absent = 0;
    int late_streak = 0;
    for (char ch : s.toCharArray()) {
      if (ch == 'A')
        absent++;
      if (ch == 'L')
        late_streak++;
      else
        late_streak = 0;
      if (absent == 2 || late_streak == 3)
        return false;
    }
    return true;
  }
}

// MAIN
public class StudentAttendanceRecord1 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(sol.checkRecord(s));
  }
}
