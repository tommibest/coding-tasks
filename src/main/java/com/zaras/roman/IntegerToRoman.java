package com.zaras.roman;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    private static Map<Integer, String> letters = new HashMap<>();

    static {
        letters.put(1, "I");
        letters.put(2, "II");
        letters.put(3, "III");
        letters.put(4, "IV");
        letters.put(5, "V");
        letters.put(6, "VI");
        letters.put(7, "VII");
        letters.put(8, "VIII");
        letters.put(9, "IX");
        letters.put(10, "X");
        letters.put(20, "XX");
        letters.put(30, "XXX");
        letters.put(40, "XL");
        letters.put(50, "L");
        letters.put(60, "LX");
        letters.put(70, "LXX");
        letters.put(80, "LXXX");
        letters.put(90, "XC");
        letters.put(100, "C");
        letters.put(200, "CC");
        letters.put(300, "CCC");
        letters.put(400, "CD");
        letters.put(500, "D");
        letters.put(600, "DC");
        letters.put(700, "DCC");
        letters.put(800, "DCCC");
        letters.put(900, "CM");
        letters.put(1000, "M");
        letters.put(2000, "MM");
        letters.put(3000, "MMM");
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.convert(3999));
        System.out.println(integerToRoman.convert(3499));
        System.out.println(integerToRoman.convert(99));
        System.out.println(integerToRoman.convert(3979));
        System.out.println(integerToRoman.convert(3496));
        System.out.println(integerToRoman.convert(123));
        System.out.println(integerToRoman.convert(85));
        System.out.println(integerToRoman.convert(58));
        //3999 -> MMMCMXCIX
        //3899 -> MMMDCCCXCIX
    }

    public String convert(int number) {
        StringBuilder sb = new StringBuilder();
        int divider = 1000;
        while (divider > 0) {
            int val = number / divider;
            if (val > 0) {
                sb.append(letters.get(val*divider));
            }
            number = number % divider;
            divider = divider / 10;
        }
        return sb.toString();
    }
}

class Solution {

    private static Map<Integer, String> letters = new HashMap<>();

    static {
        letters.put(1, "I");
        letters.put(5, "V");
        letters.put(10, "X");
        letters.put(50, "L");
        letters.put(100, "C");
        letters.put(500, "D");
        letters.put(1000, "M");
    }

    public String intToRoman(int number) {
        StringBuilder sb = new StringBuilder();
        int divider = 1000;
        while (divider > 0) {
            int val = number / divider;
            if (val <= 3) {
                for (int i = 0; i < val; i++) {
                    sb.append(letters.get(divider));
                }
            } else if (val == 4) {
                sb.append(letters.get(divider)).append(letters.get(divider * 5));
            } else if (val <= 8) {
                sb.append(letters.get(divider * 5));
                for (int i = 5; i < val; i++) {
                    sb.append(letters.get(divider));
                }
            } else if (val == 9) {
                sb.append(letters.get(divider)).append(letters.get(divider * 10));
            }
            number = number % divider;
            divider = divider / 10;
        }
        return sb.toString();
    }
}