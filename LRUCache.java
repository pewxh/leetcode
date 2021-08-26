
//      IMPORTS
import java.util.HashMap;
import java.util.Map;

//  problem #146 -> https://leetcode.com/problems/lru-cache/

class LRUCache {
  class Node {
    int key, val;
    Node next, prev;

    Node() {
    }

    Node(int k, int v) {
      key = k;
      val = v;
    }
  }

  private int size;
  private Node left, right;
  private Map<Integer, Node> cache;

  public LRUCache(int capacity) {
    size = capacity;
    left = new Node();
    right = new Node();
    left.next = right;
    right.prev = left;
    cache = new HashMap<>();
  }

  private void add(Node ptr) {
    ptr.next = left.next;
    left.next = ptr;
    ptr.prev = left;
    ptr.next.prev = ptr;
    cache.put(ptr.key, ptr);
  }

  private void remove(Node ptr) {
    ptr.next.prev = ptr.prev;
    ptr.prev.next = ptr.next;
    cache.remove(ptr.key);
  }

  public int get(int key) {
    if (cache.containsKey(key) == false)
      return -1;
    Node ptr = cache.get(key);
    remove(ptr);
    add(ptr);
    return ptr.val;
  }

  public void put(int key, int value) {
    Node ptr = new Node(key, value);
    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }
    if (cache.size() == size) {
      remove(right.prev);
    }
    add(ptr);
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
