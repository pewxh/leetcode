//        IMPORTS
//  problem #876 -> https://leetcode.com/problems/middle-of-the-linked-list/

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
  public ListNode middleNode(ListNode head) {
    ListNode slow, fast;
    slow = fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next; // slow ptr moves 1 step at a time
      fast = fast.next;
      fast = fast.next; // fast ptr moves 2 steps at a time
    } // whenever fast reaches last node or crosses the boundary, slow node is at
      // middle node
    return slow;
  }
}

public class MiddleoftheLinkedList {
  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    // (head=1) -> 2 -> 3 -> 4 -> 5
    ListNode middleNode = sol.middleNode(head);
    System.out.print(middleNode.val);
  }
}
