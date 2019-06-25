package com.zaras.patternmatching;

import java.util.HashMap;
import java.util.stream.Stream;

public class PatternMatching {

    private String buildFromPattern(String pattern, String a, String b) {
        final StringBuilder stringBuilder = new StringBuilder();
        char first = pattern.charAt(0);
        for (char c : pattern.toCharArray()) {
            if (c == first) {
                stringBuilder.append(a);
            } else {
                stringBuilder.append(b);
            }
        }
        return stringBuilder.toString();
    }

    public boolean doesMatch(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }

        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b' : 'a';

        int countOfMain = (int) pattern.chars().filter(c -> c == pattern.charAt(0)).count();
        int countOfAlt = (int) pattern.chars().filter(c -> c != pattern.charAt(0)).count();
        int firstAlt = pattern.indexOf(altChar);
        int maxMainSize = value.length() / countOfMain;

        for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
            int remainingLength = value.length() - mainSize * countOfMain;
            String first = value.substring(0, mainSize);
            if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
                int altSize = countOfAlt == 0 ? 0 : remainingLength / countOfAlt;
                int altIndex = firstAlt * mainSize;

                String second = countOfAlt == 0 ? "" : value.substring(altIndex, altSize + altIndex);

                if (buildFromPattern(pattern, first, second).equals(value)) {
                    System.out.print(String.format("[%s: %s, %s: %s]: ", mainChar, first, altChar, second));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doesMatchBrutal(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }

        int size = value.length();
        for (int mainSize = 0; mainSize <= size; mainSize++) {
            String main = value.substring(0, mainSize);
            for (int altStart = mainSize; altStart <= size; altStart++) {
                for (int altEnd = altStart; altEnd <= size; altEnd++) {
                    String alt = value.substring(altStart, altEnd);
                    String cand = buildFromPattern(pattern, main, alt);
                    if (cand.equals(value)) {
                        System.out.print(String.format("[a: %s, b: %s]: ", main, alt));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<String, String> asdf = new HashMap<>();
        new PatternMatching().testBuildingFromPattern();

    }

    public void testBuildingFromPattern() {
        String value = "CatAlaCatAla";
        Stream.of("b", "a", "aabbaa", "bb", "abab")
              .forEach(pattern -> {
                  System.out.print(String.format("Pattern [%s] ", pattern));
                  if (doesMatch(pattern, value)) {
                      System.out.println("YES");
                  } else {
                      System.out.println("NO");
                  }
              });

    }
}