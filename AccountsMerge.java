
//        IMPORTS
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  problem #721 -> https://leetcode.com/problems/accounts-merge/

class Solution {
  private int parent[];
  private int rank[];

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    initializeDSU(10000 + 5);
    Map<String, Integer> email2Id = new HashMap<>(); // maps an email to a UID( unique ID)
    Map<String, String> email2Name = new HashMap<>(); // maps an email to a name
    int uid = 0; // counter for assigning UID

    for (var account : accounts) {
      String name = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        if (!email2Id.containsKey(email)) {
          email2Id.put(email, uid++);
        }
        if (!email2Name.containsKey(email)) {
          email2Name.put(email, name);
        }
        int a = email2Id.get(account.get(1));
        int b = email2Id.get(email);
        union(a, b); // merge first email of the account with every email
      }
    }

    Map<Integer, List<String>> Id2Emails = new HashMap<>(); // map UID to all the emails with same ID

    for (var email : email2Name.keySet()) {
      int id = email2Id.get(email);
      int a = findParent(id);
      if (!Id2Emails.containsKey(a))
        Id2Emails.put(a, new ArrayList<>());
      Id2Emails.get(a).add(email);
    }

    List<List<String>> ans = new ArrayList<>();

    for (var emails : Id2Emails.values()) {
      var name = email2Name.get(emails.get(0));
      Collections.sort(emails);
      List<String> cur = new ArrayList<>();
      cur.add(name);
      for (var email : emails)
        cur.add(email);
      ans.add(cur);
    }
    return ans;
  }

  private void initializeDSU(int n) {
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  private int findParent(int a) {
    return parent[a] = (parent[a] == a ? a : findParent(parent[a]));
  }

  private void union(int a, int b) {
    a = findParent(a);
    b = findParent(b);
    if (a == b)
      return;
    if (rank[a] == rank[b])
      rank[a]++;
    if (rank[a] > rank[b])
      parent[b] = a;
    else
      parent[a] = b;
  }
}

// MAIN
public class AccountsMerge {

}
