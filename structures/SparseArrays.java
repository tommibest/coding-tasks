package org.zaras.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {

    public static void main(String[] args) {
        Map<String, Integer> strings = new HashMap();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String curr = scanner.next();
            if (strings.containsKey(curr)) {
                strings.replace(curr, strings.get(curr) + 1);
            } else {
                strings.put(curr, 1);
            }
        }
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            String currQuery = scanner.next();
            System.out.println(strings.getOrDefault(currQuery,0));
        }
    }
}
