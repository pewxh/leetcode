//        IMPORTS
//  problem #21 -> https://leetcode.com/problems/merge-two-sorted-lists/

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
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    ListNode head;
    if (l1.val < l2.val) {
      head = l1;
      head.next = mergeTwoLists(l1.next, l2);
    } else {
      head = l2;
      head.next = mergeTwoLists(l1, l2.next);
    }
    return head;
  }
}

// MAIN
public class MergeTwoSortedLists {
  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(8);
    l1.next.next.next = new ListNode(10);
    l1.next.next.next.next = new ListNode(15);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(2);
    l2.next.next = new ListNode(9);
    l2.next.next.next = new ListNode(10);
    l2.next.next.next.next = new ListNode(20);

    ListNode head = sol.mergeTwoLists(l1, l2);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
