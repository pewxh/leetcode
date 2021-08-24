//        IMPORTS

//  problem #138 -> https://leetcode.com/problems/copy-list-with-random-pointer/

//  NOTE :- *COMMENT THE LISTNODE CLASS BEFORE SUBMITTING THIS CODE IN LEETCODE*
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

class Solution {
  public Node copyRandomList(Node head) {
    if (head == null)
      return null;
    Node ptr = head;
    while (ptr != null) {
      Node tmp = new Node(ptr.val);
      tmp.next = ptr.next;
      ptr.next = tmp;
      ptr = tmp.next;
    }
    Node copyHead = head.next;
    Node cp_ptr = copyHead;
    ptr = head;

    while (cp_ptr != null && ptr != null) {
      cp_ptr.random = ptr.random;
      if (cp_ptr.random != null)
        cp_ptr.random = cp_ptr.random.next;
      cp_ptr = cp_ptr.next;
      if (cp_ptr != null)
        cp_ptr = cp_ptr.next;
      ptr = ptr.next.next;
    }

    ptr = head;
    cp_ptr = copyHead;

    while (cp_ptr != null && ptr != null) {
      ptr.next = cp_ptr.next;
      ptr = ptr.next;
      cp_ptr.next = (ptr == null) ? null : ptr.next;
      cp_ptr = cp_ptr.next;
    }
    return copyHead;
  }
}

// MAIN
public class CopyListwithRandomPointer {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.random = null;
    head.next.random = head;
    head.next.next.random = null;
    Node copyHead = sol.copyRandomList(head);
    while (copyHead != null) {
      System.out.println(copyHead.val + " " + copyHead.random);
      copyHead = copyHead.next;
    }
  }
}
