package com.zaras.algorithms;

import java.util.Scanner;

class CandleCake {

    static int birthdayCakeCandles(int n, int[] ar) {
        int tallest = 0;
        int counter = 0;
        for (int candle : ar) {
            if ( candle > tallest) {
                tallest = candle;
                counter = 1;
            } else if (candle == tallest) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}