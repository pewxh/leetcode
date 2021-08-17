//        IMPORTS
//  problem #206 -> https://leetcode.com/problems/reverse-linked-list/

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
  public ListNode reverseList(ListNode head) {
    ListNode p, q, r;
    p = null;
    q = head;
    while (q != null) {
      r = q.next;
      q.next = p;
      p = q;
      q = r;
    }
    return p;
  }
}

// MAIN
public class ReverseLinkedList {
  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    // (head=1) -> 2 -> 3 -> 4 -> 5
    head = sol.reverseList(head);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
