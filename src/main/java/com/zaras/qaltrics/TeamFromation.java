package com.zaras.qaltrics;

import java.util.Arrays;

public class TeamFromation {
    public static void main(String[] args) {
        System.out.println(teamFormation(new int[]{17, 12, 10, 2, 21, 2, 11, 20, 8}, 3, 4));
    }

    static long teamFormation(int[] score, int team, int m) {
        long result = 0;
        int leftPointer = m,
                rightPointer = score.length - m;
        int[] left = Arrays.stream(Arrays.copyOfRange(score, 0, leftPointer)).sorted().toArray();
        int[] right = Arrays.stream(Arrays.copyOfRange(score, rightPointer, score.length)).sorted().toArray();
        while (team > 0) {
            if (left[m - 1] > right[m - 1]) {
                result += left[m - 1];
                left[m - 1] = score[leftPointer];
                left = Arrays.stream(left).sorted().toArray();
                leftPointer++;
            } else {
                result += right[m - 1];
                right[m - 1] = score[rightPointer];
                right = Arrays.stream(right).sorted().toArray();
                rightPointer--;
            }
            team--;
        }
        return result;
    }

}
