
//        IMPORTS
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  problem #210 -> https://leetcode.com/problems/course-schedule-ii/

class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < numCourses; i++)
      adj.add(new ArrayList<Integer>());
    for (int[] i : prerequisites)
      adj.get(i[1]).add(i[0]);
    List<Integer> topo = kanhsAlgo(adj, numCourses);
    if (topo.size() != numCourses)
      topo.clear();
    return topo.stream().mapToInt(i -> i).toArray();
  }

  private List<Integer> kanhsAlgo(ArrayList<ArrayList<Integer>> adj, int numCourses) {
    List<Integer> topo = new ArrayList<>();
    Queue<Integer> q = new LinkedList<Integer>();
    int inDegree[] = new int[numCourses];
    for (int i = 0; i < adj.size(); i++) {
      for (int j = 0; j < adj.get(i).size(); j++) {
        inDegree[adj.get(i).get(j)]++;
      }
    }
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0)
        q.add(i);
    }
    while (q.size() > 0) {
      int node = q.poll();
      topo.add(node);
      for (int nb : adj.get(node)) {
        if (--inDegree[nb] == 0)
          q.add(nb);
      }
    }
    return topo;
  }
}

// MAIN
public class CourseSchedule2 {
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
    int order[] = sol.findOrder(n, prerequisites);
    for (int i : order)
      System.out.print(i + " ");
  }
}
