package org.example;

public class StringProcessor {
    public void stringProcessor(String[] args) {
        //
    }


    public String reverseWords(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Строка не может быть пустой");
        }

        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        int wordIndex = words.length - 1; // индекс для обхода массива слов с конца

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                result.append(' ');
            } else {
                if (wordIndex >= 0) {
                    result.append(words[wordIndex]);
                    wordIndex--;
                }
                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }
                i--;
            }
            return result.toString();
        }
        return "";
    }
}