
//        IMPORTS

//  problem #24 ->  https://leetcode.com/problems/swap-nodes-in-pairs/

class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null)
      return head;
    var newHead = head.next;
    var tail = swapPairs(newHead.next);
    newHead.next = head;
    head.next = tail;
    return newHead;
  }
}

// MAIN
public class SwapNodesinPairs {

}
