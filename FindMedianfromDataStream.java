
//        IMPORTS
import java.util.Collections;
import java.util.PriorityQueue;

//  problem #295 -> https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {

  private PriorityQueue<Integer> firsthalf;
  private PriorityQueue<Integer> secondhalf;

  public MedianFinder() {

    // make firsthalf as a maxheap
    // make secondhalf as a min heap

    firsthalf = new PriorityQueue<Integer>(Collections.reverseOrder());
    secondhalf = new PriorityQueue<Integer>();
  }

  public void addNum(int num) {
    if (firsthalf.isEmpty()) {
      firsthalf.offer(num);
    } else if (firsthalf.size() > secondhalf.size()) {
      if (num > firsthalf.peek()) {
        secondhalf.offer(num);
      } else {
        secondhalf.offer(firsthalf.poll());
        firsthalf.offer(num);
      }
    } else {
      if (secondhalf.peek() > num) {
        firsthalf.offer(num);
      } else {
        firsthalf.offer(secondhalf.poll());
        secondhalf.offer(num);
      }
    }
  }

  public double findMedian() {
    if ((firsthalf.size() + secondhalf.size()) % 2 == 0) {
      return (firsthalf.peek() + secondhalf.peek()) / 2.0;
    } else {
      return firsthalf.peek();
    }
  }
}

/*
 * Initially the idea is to split the array(stream of numbers) and store them in
 * 2 Data Structures such that the biggest element of first half is always
 * lesser than or equal to the smallest number in second half
 * 
 * eg-> 1) arr = [1,2,3,4,5] [1,2,3] [4,5]
 * 
 * 2) arr = [1,2,3,4,5,6] [1,2,3] [4,5,6]
 * 
 * To find the median :
 * 
 * Case 1: Total number of elements are odd (eg 1): median = max(first half) = 3
 * 
 * Case 2: Total number of elements are even (eg 2) : median = ( max(first half)
 * + min(second half) ) / 2 = ( (3) + (4) ) / 2 = 3.5
 * 
 * In order to find the maximum from the first half and smallest from the second
 * half effeciently we maintain MAX HEAP and MIN HEAP for first half and second
 * half resp.
 * 
 * // note: in case of odd numbers the extra element is always kept in the first
 * half ( could be anyways tho as long as you take care of it in the
 * implementation)
 */

public class FindMedianfromDataStream {

}
