package org.saurabh.sliding_window.longest_substring_unique_char_3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> charCount = new HashMap<>();
        Character repetedChar = null;
        int i = 0, j = 0;
        int longestSubStr = 1;
        char[] string = s.toCharArray();

        while(true){
            while(j < string.length && (! charCount.containsKey(string[j]) || charCount.get(string[j]) == 0)) {
                charCount.put(string[j], 1);
                longestSubStr = Math.max(longestSubStr, j-i+1);
                j++;
            }
            if(j < string.length) {
                repetedChar = string[j];
            }

            while(i <= j && repetedChar != null && string[i] != repetedChar) {
                charCount.put(string[i], 0);
                i++;
            }
            charCount.put(string[i], 1);
            i++;
            j++;

            if(j >= string.length) {
                break;
            }
        }
        return longestSubStr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("s"));
    }
}
