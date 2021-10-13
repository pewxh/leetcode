
//        IMPORTS
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//  problem #973 -> https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {

  class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  class Node {
    double dist;
    Pair pair;

    public Node(double dist, Solution.Pair pair) {
      this.dist = dist;
      this.pair = pair;
    }
  }

  public int[][] kClosest(int[][] points, int k) {
    if (k == points.length)
      return points;

    PriorityQueue<Node> minheap;
    minheap = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(Node n1, Node n2) {
        return Double.compare(n2.dist, n1.dist);
      }
    });

    for (var it : points) {
      int x = it[0];
      int y = it[1];
      var pair = new Pair(x, y);
      double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
      minheap.add(new Node(dist, pair));
      if (minheap.size() > k)
        minheap.poll();
    }

    int res[][] = new int[k][2];
    for (int i = 0; i < k; i++) {
      res[i][0] = minheap.peek().pair.x;
      res[i][1] = minheap.poll().pair.y;
    }
    return res;
  }
}

// MAIN
public class KClosestPointstoOrigin {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int points[][] = new int[n][2];
    for (int i = 0; i < n; i++) {
      points[i][0] = sc.nextInt();
      points[i][1] = sc.nextInt();
    }
    int k = sc.nextInt();
    sc.close();
    for (var it : sol.kClosest(points, k))
      System.out.println(Arrays.toString(it));
  }
}
