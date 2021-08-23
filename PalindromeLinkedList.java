//        IMPORTS
//  problem #234 -> https://leetcode.com/problems/palindrome-linked-list/

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
  private ListNode reverse(ListNode head) {
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

  public boolean isPalindrome(ListNode head) {
    ListNode fast, slow;
    fast = head;
    slow = head;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    slow.next = reverse(slow.next);
    slow = slow.next;

    while (slow != null) {
      if (head.val != slow.val)
        return false;
      head = head.next;
      slow = slow.next;
    }
    return true;
  }
}

public class PalindromeLinkedList {
  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    // (head=1) -> 2 -> 3 -> 4 -> 5
    System.out.println(sol.isPalindrome(head));
  }
}
