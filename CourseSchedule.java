
//        IMPORTS
import java.util.Scanner;
import java.util.ArrayList;

//  problem #207 -> https://leetcode.com/problems/course-schedule/

class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(numCourses);
    for (int i = 0; i < numCourses + 1; i++)
      adj.add(new ArrayList<Integer>()); // add n empty rows to the adjList
    for (int i = 0; i < prerequisites.length; i++) {
      int u = prerequisites[i][0], v = prerequisites[i][1];
      adj.get(v).add(u);
    }

    boolean vis[] = new boolean[numCourses + 1];
    boolean currVis[] = new boolean[numCourses + 1];

    for (int i = 1; i <= numCourses; i++) {
      if (!vis[i]) {
        if (checkCycle(adj, vis, currVis, i))
          return false;
      }
    }
    return true;
  }

  private boolean checkCycle(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] currVis, int curr) {
    vis[curr] = true;
    currVis[curr] = true;
    for (Integer nb : adj.get(curr)) {
      if (!vis[nb]) {
        if (checkCycle(adj, vis, currVis, nb))
          return true;
      } else if (currVis[nb])
        return true;
    }
    currVis[curr] = false;
    return false;
  }
}

// MAIN
public class CourseSchedule {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt(); // number of edges , size of prerequisites
    int prerequisites[][] = new int[m][2];
    for (int i = 0; i < m; i++) {
      prerequisites[i][0] = sc.nextInt();
      prerequisites[i][1] = sc.nextInt();
    }
    sc.close();
    System.out.println(sol.canFinish(n, prerequisites));
  }
}
