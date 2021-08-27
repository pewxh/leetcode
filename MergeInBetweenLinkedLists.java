//        IMPORTS

//  problem #1669 -> https://leetcode.com/problems/merge-in-between-linked-lists/

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
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode ptr = list1;
    for (int i = 1; i < a; i++)
      ptr = ptr.next;
    ListNode del_l = ptr.next;
    ptr.next = list2;
    ptr = del_l;
    for (int i = a; i < b; i++)
      ptr = ptr.next;
    ListNode del_r = ptr;
    ptr = list2;
    while (ptr.next != null)
      ptr = ptr.next;
    ptr.next = del_r.next;
    return list1;

  }
}

// MAIN
public class MergeInBetweenLinkedLists {
  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode list1 = new ListNode(0);
    list1.next = new ListNode(1);
    list1.next.next = new ListNode(2);
    list1.next.next.next = new ListNode(3);
    list1.next.next.next.next = new ListNode(4);
    list1.next.next.next.next.next = new ListNode(5);
    ListNode list2 = new ListNode(1000000);
    list2.next = new ListNode(1000001);
    list2.next.next = new ListNode(1000002);
    int a = 3, b = 4;
    ListNode head = sol.mergeInBetween(list1, a, b, list2);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
