//        IMPORTS
//  problem #142 -> https://leetcode.com/problems/linked-list-cycle-ii/

//  NOTE :- *COMMENT THE LISTNODE CLASS BEFORE SUBMITTING THIS CODE IN LEETCODE*
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow)
        break; // breaks a loop in case a cycle is present
    }
    if (fast == null || fast.next == null)
      return null; // no cycle is detected
    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }
}

// MAIN
public class LinkedListCycle2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = head.next.next;
    // (head=1) -> 2 -> 3 -> 4 -> 5 -> 3
    ListNode cycleNode = sol.detectCycle(head);
    String res = (cycleNode == null) ? "no cycle" : "cycle starts from node " + cycleNode.val;
    System.out.print(res);
  }
}
