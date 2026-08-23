package org.saurabh.array_strings.reverseWords_151;

public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = parts.length-1;  i > -1; i--){
            String word = parts[i];
            if(word.length()>0){
                sb.append(word);
                sb.append(" ");
            }
        }
        return (sb.toString()).trim();
    }

}
