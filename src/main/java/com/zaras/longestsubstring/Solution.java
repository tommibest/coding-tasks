package com.zaras.longestsubstring;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int result = 1;
        int i = 0;
        while (i < s.length() - result) {
            int j = i;
            while (j < s.length() && !s.substring(i, j).contains(String.valueOf(s.charAt(j)))) {
                if ((j - i + 1) > result) {
                    result = j - i + 1;
                }
                j++;
            }
            if (j < s.length()) {
                if (s.charAt(j) == s.charAt(i)) {
                    i++;
                } else {
                    i = s.indexOf(s.charAt(j), i + 1) + 1;
                }
            }
        }
        return result;
    }

    //quicker
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int result = 1;
        int i = 0;
        while (i < s.length() - result) {
            for (int j = i; j < s.length(); j++) {
                if (!s.substring(i, j).contains(String.valueOf(s.charAt(j)))) {
                    if ((j-i+1) > result) {
                        result = j-i+1;
                    }
                } else {
                    i = s.indexOf(s.charAt(j), i);
                    break;
                }
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("a"));
        System.out.println(solution.lengthOfLongestSubstring("   "));
        System.out.println(solution.lengthOfLongestSubstring("abcbabab"));
        System.out.println(solution.lengthOfLongestSubstring("abcbababcd"));
    }
}