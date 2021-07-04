//			IMPORTS
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// problem #438 -> https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {
	public List<Integer> findAnagrams(String s,String p){
		List<Integer> res = new ArrayList<Integer>();
		int p_size,s_size;
		p_size = p.length();
		s_size = s.length();
		if(p_size > s_size)
			return res;
		Map<Character, Integer> map_s , map_p;
		map_p = new HashMap<>();
		map_s = new HashMap<>();
		
		for(char c : p.toCharArray()){
			if(map_p.containsKey(c))
				map_p.put(c,map_p.get(c)+1);
			else
				map_p.put(c,1);
		}
		
		for(int i=0;i<s_size;i++){
			char c = s.charAt(i);
			if(map_s.containsKey(c))
				map_s.put(c,map_s.get(c)+1);
			else
				map_s.put(c,1);
			
			if(i >= p_size){
				char prev = s.charAt(i-p_size);
				int prev_count = map_s.get(prev);
				if(prev_count == 1)
					map_s.remove(prev);
				else
					map_s.put(prev,prev_count-1);
			}

			if(map_p.equals(map_s))
				res.add(i - p_size + 1);
		}
		return res;
	}	
}

//				MAIN
public class FindAllAnagramsInAString {
	public static void main(String[] args) {
		String s , p;
		Solution sol = new Solution();
		Scanner sc = new Scanner(System.in);
		s = sc.next(); p = sc.next();
		List<Integer> res = sol.findAnagrams(s, p);
		System.out.println(res);
	}
}
