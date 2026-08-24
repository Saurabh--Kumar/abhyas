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
                sb.append(getSpace(spacing.get(i)));
            }
        }

        return sb.toString();
    }

    private char[] getSpace(Integer size) {
        char[] spaces = new char[size];
        for(int i = 0; i < size; i++){
            spaces[i] = ' ';
        }
        return spaces;
    }


}
