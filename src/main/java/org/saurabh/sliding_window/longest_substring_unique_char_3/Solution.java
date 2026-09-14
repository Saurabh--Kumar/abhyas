package org.saurabh.sliding_window.longest_substring_unique_char_3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> lastCharPosition = new HashMap<>();
        int i = 0;
        int longestSubStr = 1;
        char[] string = s.toCharArray();

        for(int j = 0; j< string.length; j++){
           char c = string[j];
           if(lastCharPosition.containsKey(c) && lastCharPosition.get(c) >= i){
               i = lastCharPosition.get(c) +1;
           }
           lastCharPosition.put(c, j);

           longestSubStr = Math.max(longestSubStr, j-i +1);
        }

        return longestSubStr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("baaabca"));
    }
}
