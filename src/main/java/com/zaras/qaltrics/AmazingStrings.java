package com.zaras.qaltrics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class AmazingStrings {


    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        } else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int[] res;
        int words_size = 0;
        //words_size = Integer.parseInt(in.nextLine().trim());

        /*String[] words = new String[words_size];
        for (int i = 0; i < words_size; i++) {
            String words_item;
            try {
                words_item = in.nextLine();
            } catch (Exception e) {
                words_item = null;
            }
            words[i] = words_item;
        }*/

        String[] words = {"ab", "aab", "abb", "abab", "abaaaba"};
        res = minimalOperations(words);
        for (int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    private static int[] minimalOperations(String[] words) {
        int[] ops = new int[words.length];
        for (int wordNo = 0; wordNo < words.length; wordNo++) {
            ops[wordNo] = 0;
            char[] chars = words[wordNo].toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == chars[i + 1]) {
                    ops[wordNo]++;
                    i++;
                }
            }
        }
        return ops;
    }
}
