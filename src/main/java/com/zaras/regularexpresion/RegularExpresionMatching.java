package com.zaras.regularexpresion;

public class RegularExpresionMatching {


    public boolean isMatchRecursion(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean firstMatch = (!text.isEmpty() &&
            (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatchRecursion(text, pattern.substring(2)) ||
                (firstMatch && isMatchRecursion(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatchRecursion(text.substring(1), pattern.substring(1));
        }
    }


    public boolean isMatch(String s, String p) {
        char[] letters = new char[s.length()];
        int[] occurence = new int[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letters[index] == 0) {
                letters[index] = s.charAt(i);
                occurence[index] = 1;
            } else if (letters[index] == s.charAt(i)) {
                occurence[index]++;
            } else {
                letters[++index] = s.charAt(i);
                occurence[index] = 1;
            }
        }
        for (char[] patternElement : splitPattern(p)) {

        }
        return false;
    }

    private char[][] splitPattern(String p) {
        char[][] result = new char[p.length()][2];
        char[] pattern = p.toCharArray();
        int index = 0;
        for (int i = 0; i < p.length(); i++) {
            result[index][0] = pattern[i];
            if (pattern[i + 1] != '*' || pattern[i + 1] != '+') {
                result[index][1] = pattern[i + 1];
            } else {
                result[index][1] = '1';
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RegularExpresionMatching expresionMatching = new RegularExpresionMatching();
        System.out.println(expresionMatching.isMatchRecursion("aaaabc", "a*.b*c*"));
    }
}
