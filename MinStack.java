//        IMPORTS

//  problem #115 -> https://leetcode.com/problems/min-stack/

class MinStack {
  class StackNode {
    int val;
    int min;
    StackNode next;

    public StackNode(int val, int min) {
      this.val = val;
      this.min = min;
    }
  }

  StackNode top;

  public MinStack() {
    top = null;
  }

  public void push(int val) {
    var node = new StackNode(val, val);
    if (top == null) {
      top = node;
    } else {
      node.min = Math.min(top.min, val);
      node.next = top;
    }
    top = node;
  }

  public void pop() {
    top = top.next;
  }

  public int top() {
    return top.val;
  }

  public int getMin() {
    return top.min;
  }
}
