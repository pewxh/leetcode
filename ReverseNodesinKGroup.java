
//        IMPORTS

//  problem #25 -> https://leetcode.com/problems/reverse-nodes-in-k-group/

class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    int len = length(head);
    if (len < k)
      return head;
    ListNode prev = null;
    ListNode curr = head;
    for (int i = 0; i < k; i++) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    if (curr != null) {
      head.next = reverseKGroup(curr, k);
    }
    return prev;
  }

  private int length(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }
}

// MAIN
public class ReverseNodesinKGroup {

}
