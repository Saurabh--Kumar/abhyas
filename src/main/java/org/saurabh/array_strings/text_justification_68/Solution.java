package org.saurabh.array_strings.text_justification_68;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while(i < words.length){
            int selectedWordsLength = 0;
            List<String> selectedWords = new ArrayList<>();
            while(i < words.length
                    && (selectedWordsLength + selectedWords.size()  + words[i].length() <= maxWidth)){
                selectedWordsLength += words[i].length();
                selectedWords.add(words[i]);
                i++;
            }
            List<Integer> spacing;
            if(i == words.length){
                spacing = getLastLineSpacing(selectedWords.size(), selectedWordsLength, maxWidth);
            } else {
                spacing = getSpacing(selectedWords.size(), selectedWordsLength, maxWidth);
            }
            String line = getLine(selectedWords, spacing);
            output.add(line);

        }

        return output;
    }

    private List<Integer> getLastLineSpacing(int selectedWordsCount, int selectedWordsLength, int maxWidth) {
        List<Integer> spacing = new ArrayList<>();
        for(int i = 0; i < selectedWordsCount; i++) {
            if(i == selectedWordsCount-1) {
                spacing.add(maxWidth - selectedWordsCount - selectedWordsLength +1);
            } else {
                spacing.add(1);
            }
        }

        return spacing;
    }

    private List<Integer> getSpacing(int selectedWordsCount, int selectedWordsLength, int maxWidth) {
        if (selectedWordsCount == 1){
            return List.of(maxWidth - selectedWordsLength);
        }

        List<Integer> spacing = new ArrayList<>(selectedWordsCount-1);
        int equalSpaces = (maxWidth - selectedWordsLength)/(selectedWordsCount - 1);
        int remainingSpaces = (maxWidth - selectedWordsLength) - (equalSpaces*(selectedWordsCount - 1));


        for(int i = 0; i< selectedWordsCount-1; i++){
            if(i < remainingSpaces){
                spacing.add(equalSpaces+1);
            }
            else {
                spacing.add(equalSpaces);
            }
        }
        return spacing;
    }

    private String getLine(List<String> selectedWords, List<Integer> spacing) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < selectedWords.size(); i++){
            sb.append(selectedWords.get(i));
            if(i < spacing.size()){
                sb.append(" ".repeat(spacing.get(i)));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words1 = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth1 = 16;
        System.out.println("Test Case 1:");
        System.out.println("Input: words = " + java.util.Arrays.toString(words1) + ", maxWidth = " + maxWidth1);
        List<String> result1 = solution.fullJustify(words1, maxWidth1);
        for (String line : result1) {
            System.out.println("\"" + line + "\" (length: " + line.length() + ")");
        }
        System.out.println();

        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth2 = 16;
        System.out.println("Test Case 2:");
        System.out.println("Input: words = " + java.util.Arrays.toString(words2) + ", maxWidth = " + maxWidth2);
        List<String> result2 = solution.fullJustify(words2, maxWidth2);
        for (String line : result2) {
            System.out.println("\"" + line + "\" (length: " + line.length() + ")");
        }
        System.out.println();

        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth3 = 20;
        System.out.println("Test Case 3:");
        System.out.println("Input: words = " + java.util.Arrays.toString(words3) + ", maxWidth = " + maxWidth3);
        List<String> result3 = solution.fullJustify(words3, maxWidth3);
        for (String line : result3) {
            System.out.println("\"" + line + "\" (length: " + line.length() + ")");
        }
    }


}
