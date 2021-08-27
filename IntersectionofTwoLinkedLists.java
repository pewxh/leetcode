
//        IMPORTS
import java.util.HashSet;

//  problem #160 -> https://leetcode.com/problems/intersection-of-two-linked-lists/

//  NOTE :- *COMMENT THE LISTNODE CLASS BEFORE SUBMITTING THIS CODE IN LEETCODE*
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {
  private int len1 = -1, len2 = -1;

  private int len(ListNode ptr) {
    int length = 0;
    while (ptr != null) {
      length++;
      ptr = ptr.next;
    }
    return length;
  }

  private ListNode travel(ListNode ptr, int dist) {
    while (dist-- > 0) {
      ptr = ptr.next;
    }
    return ptr;
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (len1 == -1 || len2 == -1) {
      len1 = len(headA);
      len2 = len(headB);
    }
    int difference = Math.abs(len1 - len2);
    if (len1 > len2)
      headA = travel(headA, difference);
    else
      headB = travel(headB, difference);

    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }
}

// public class Solution {
// public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
// HashSet<ListNode> vis = new HashSet<>();
// ListNode p = headA;
// ListNode q = headB;
// while (p != null) {
// vis.add(p);
// p = p.next;
// }
// while (q != null) {
// if (vis.contains(q))
// return q;
// q = q.next;
// }
// return null;
// }
// }

public class IntersectionofTwoLinkedLists {
  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode headA = new ListNode(1);
    headA.next = new ListNode(2);
    headA.next.next = new ListNode(8);
    headA.next.next.next = new ListNode(10);
    headA.next.next.next.next = new ListNode(15);
    ListNode headB = new ListNode(1);
    headB.next = new ListNode(2);
    headB.next.next = new ListNode(9);
    headB.next.next.next = new ListNode(10);
    headB.next.next.next.next = headA.next.next;
    System.out.print(sol.getIntersectionNode(headA, headB).val);
  }
}
