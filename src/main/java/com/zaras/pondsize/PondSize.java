package com.zaras.pondsize;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PondSize {

    public static void main(String[] args) {
        int[][] area = new int[][]{
            {0, 0, 2, 0},
            {0, 1, 0, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 1}
        };

        PondSize pondSize = new PondSize();
        List<Integer> expected = Arrays.asList(1, 2, 4);
        List<Integer> result = pondSize.calculate(area);
        System.out.println(result);
        System.out.println(result.containsAll(expected));
    }

    private List<Integer> calculate(int[][] area) {
        List<Integer> results = new LinkedList<>();
        int sizeX = area[0].length;
        int sizeY = area.length;
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                int result = visit(area, x, y);
                if (result != 0) {
                    ((LinkedList<Integer>) results).addLast(result);
                }
            }
        }
        return results;
    }

    private int visit(int[][] area, int x, int y) {
        int sizeX = area[0].length;
        int sizeY = area.length;
        int size = 0;

        if (area[y][x] == 0) {
            area[y][x] = -1;

            size++;

            if ((x + 1 < sizeX) && (y - 1 >= 0)) {
                size += visit(area, x + 1, y - 1);
            }
            if (x + 1 < sizeX) {
                size += visit(area, x + 1, y);
            }
            if ((x + 1 < sizeX) && (y + 1 < sizeY)) {
                size += visit(area, x + 1, y + 1);
            }
            if (y + 1 < sizeY) {
                size += visit(area, x, y + 1);
            }
            if ((x - 1 >= 0) && (y + 1 < sizeY)) {
                size += visit(area, x - 1, y + 1);
            }
            if (x - 1 >= 0) {
                size += visit(area, x - 1, y);
            }
            if ((x - 1 >= 0) && (y - 1 >= 0)) {
                size += visit(area, x - 1, y - 1);
            }
            if (y - 1 >= 0) {
                size += visit(area, x, y - 1);
            }
        }
        return size;
    }

}
