//			IMPORTS
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// problem #3 -> https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution{
	public int lengthOfLongestSubstring(String s){
		int startIdx = 0;
		int maxLen = 1;
		Map<Character,Integer> lastSeen = new HashMap<>();
		if(s.length() == 0)
			return 0;
		for(int i=0;i<s.length();i++){
			Character c = s.charAt(i);
			if(lastSeen.containsKey(c)){
				startIdx = Math.max(startIdx,1 + lastSeen.get(c));
			}
			lastSeen.put(c,i);
			maxLen = Math.max(maxLen,i - startIdx + 1);
		}
		return maxLen;
	}
}

//				MAIN
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Solution sol = new Solution();
		int res = sol.lengthOfLongestSubstring(s);
		System.out.println(res);
	}	
}
