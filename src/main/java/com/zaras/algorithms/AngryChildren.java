package com.zaras.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }
        if (n >= 2 && k >= 2 && n >= k) {
            System.out.println(calculateUnfairnes(n, k, list));
        }
    }

    private static int calculateUnfairnes(int n, int k, int[] list) {
        int unfairness = Integer.MAX_VALUE;
        int probableUnfairness = unfairness;
        Arrays.sort(list);
        for (int i = 0; i + k - 1 < n; i++) {
            unfairness = (list[(k - 1) + i] - list[i]) < unfairness ? (list[(k - 1) + i] - list[i]) : unfairness;
        }
        return unfairness;
    }
}
