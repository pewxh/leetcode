//        MAIN
import java.util.Scanner;
import java.util.Stack;

//  problem #71 -> https://leetcode.com/problems/simplify-path/

class Solution {
  public String simplifyPath(String path) {
    Stack<String> res_stack = new Stack<>();
    int l = 0 , r = 0, n = path.length();
    while(l < n){
      while(l < n && path.charAt(l) == '/') l++;
      r = l;
      while(r < n && path.charAt(r) != '/') r++;
      String t = path.substring(l,r);
        System.out.println(t);
      if(t.equals(".."))
          if(res_stack.size() > 0)
            res_stack.pop();
      if(!t.equals(".")  && !t.equals("") && !t.equals(".."))
        res_stack.push(t);
      l = r + 1;
    }
    StringBuilder res = new StringBuilder();
    while(res_stack.size()>0){
        res.insert(0, res_stack.pop());
        res.insert(0, "/");
    }
     System.out.print(res);
    if(res.length()==0)
      res.append("/");
    return res.toString();
  }
}

//        MAIN
class SimplifyPath{
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String path = sc.next();
    sc.close();
    String canonicalPath = sol.simplifyPath(path);
    System.out.println(canonicalPath);
  }
}