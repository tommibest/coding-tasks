package com.zaras.qaltrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class TeamFormationUgly {
    public static void main(String[] args) {
        System.out.println(teamFormation(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
    }

    static long teamFormation(int[] score, int team, int m) {
        long result = 0;
        if (score.length == team) {
            result = Arrays.stream(score).asLongStream().sum();
        } else {
            List<Integer> scores = new ArrayList<>();
            Arrays.stream(score).forEach(s -> scores.add(s));
            while (team > 0) {
                Object[] firstM = scores.subList(0, m > scores.size() - 1 ? m : scores.size() - 1).stream().sorted().toArray();
                int max1 = (Integer)firstM[firstM.length-1];

                int startIndex = (scores.size() - m) > 0 ? (scores.size() - m) : 0;
                Object[] lastM = scores.subList(startIndex, scores.size() - 1).stream().sorted().toArray();
                int max2 = (Integer)lastM[lastM.length-1];
                if (max1 >= max2) {
                    result += max1;
                    ListIterator iter = scores.listIterator();
                    while (iter.hasNext()) {
                        if (iter.next().equals(max1)) {
                            iter.remove();
                            break;
                        }
                    }
                } else {
                    result += max2;
                    ListIterator iter = scores.listIterator(scores.size() - 1 - m);
                    while (iter.hasNext()) {
                        if (iter.next().equals(max2)) {
                            iter.remove();
                            break;
                        }
                    }
                }
                team--;
            }
        }
        return result;
    }
}