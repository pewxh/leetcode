//        IMPORTS
//  problem #19 -> https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast, slow;
    fast = slow = head;
    while (n-- > 0)
      fast = fast.next;
    if (fast == null)
      return head.next; // corner case
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }
}

// MAIN
public class RemoveNthNodeFromEndofList {
  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    // (head=1) -> 2 -> 3 -> 4 -> 5
    int n = 3;
    head = sol.removeNthFromEnd(head, n);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
