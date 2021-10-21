
//        IMPORTS

//  problem #328 -> https://leetcode.com/problems/odd-even-linked-list/

class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      even.next = even.next.next;
      odd = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }
}

// MAIN
public class OddEvenLinkedList {

}
