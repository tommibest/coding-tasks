package com.zaras.pondsize;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PondSize {

    public static void main(String[] args) {
        int[][] area = new int[][]{
            {0, 0, 1, 2, 0},
            {0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 2, 1}
        };

        PondSize pondSize = new PondSize();
        List<Integer> expected = Arrays.asList(2, 3, 3);
        List<Integer> result = pondSize.calculate(area);
        System.out.println(result);
        System.out.println(result.containsAll(expected));
    }

    private List<Integer> calculate(int[][] area) {
        LinkedList<Integer> results = new LinkedList<>();
        for (int x = 0; x < area.length; x++) {
            for (int y= 0; y < area[0].length; y++) {
                int result = visit(area, x, y);
                if (result != 0) {
                    results.addLast(result);
                }
            }
        }
        return results;
    }

    private int visit(int[][] area, int x, int y) {
        if (x < 0 || x >= area.length ||
            y < 0 || y >= area[0].length ||
            area[x][y] != 0) {
            return 0;
        }

        int size = 1;
        area[x][y] = -1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                size += visit(area, x + i, y + j);
            }
        }
        return size;
    }

}
