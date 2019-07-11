package com.zaras.algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N >= 1 && N <= 100) {
            BigInteger result = BigInteger.ONE;
            for (long i = 1; i <= N; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            System.out.println(result.toString());
        }
    }
}
