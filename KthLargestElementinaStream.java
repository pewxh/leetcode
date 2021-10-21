
//        IMPORTS
import java.util.PriorityQueue;

//  problem #703 -> https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {
  int k;
  PriorityQueue<Integer> minheap = new PriorityQueue<>();

  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (int it : nums)
      add(it);
  }

  public int add(int val) {
    minheap.offer(val);
    if (minheap.size() > k)
      minheap.poll();
    return minheap.peek();
  }
}

// MAIN
public class KthLargestElementinaStream {

}
