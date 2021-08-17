//        IMPORTS
//  problem #2 -> https://leetcode.com/problems/add-two-numbers/

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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = (l1.val + l2.val);
    int carry = sum / 10;
    ListNode head = new ListNode(sum % 10);
    l1 = l1.next;
    l2 = l2.next;
    ListNode current = head;
    while (l1 != null && l2 != null) {
      sum = l1.val + l2.val + carry;
      carry = sum / 10;
      current.next = new ListNode(sum % 10);
      l1 = l1.next;
      l2 = l2.next;
      current = current.next;
    }
    while (l1 != null) {
      sum = l1.val + carry;
      carry = sum / 10;
      current.next = new ListNode(sum % 10);
      l1 = l1.next;
      current = current.next;
    }
    while (l2 != null) {
      sum = l2.val + carry;
      carry = sum / 10;
      current.next = new ListNode(sum % 10);
      l2 = l2.next;
      current = current.next;
    }
    if (carry > 0)
      current.next = new ListNode(carry);
    return head;
  }
}

// MAIN
public class AddTwoNumbers {
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

    ListNode head = sol.addTwoNumbers(l1, l2);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }
}
