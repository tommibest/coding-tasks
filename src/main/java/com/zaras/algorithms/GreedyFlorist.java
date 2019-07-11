package com.zaras.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {

    static int getMinimumCost(int n, int k, int[] c) {
        Arrays.sort(c);
        int result = 0;
        int x = 0;
        for (int i = c.length; i >= 0; i--) {
            result = result + (x + 1) * c[i];
            x = (c.length - i) / k;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int minimumCost = getMinimumCost(n, k, c);
        System.out.println(minimumCost);
    }
}
