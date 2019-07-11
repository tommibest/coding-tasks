package com.zaras.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Radiostation {

    private static int calculate( int zasieg, int[] domy) {
        int stations = 0;
        for (int curr=0; curr < domy.length;) {
            int station = findClosestStation(curr,domy,zasieg);
            curr = findNextRegion(station,domy,zasieg);
            stations++;
        }
        return stations;
    }

    private static int findNextRegion(int station, int[] domy, int zasieg) {
        for (int nrDomu = station+1; nrDomu < domy.length; nrDomu++) {
            if (domy[nrDomu] > domy[station]+zasieg ) {
                return nrDomu;
            }
        }
        return domy.length;
    }

    private static int findClosestStation(int nrDomu, int[] domy, int zasieg) {
        int stacja = nrDomu;
        for (int next=1; next < domy.length;) {
            if (domy[nrDomu+next] <= domy[nrDomu]+zasieg) {
                stacja = nrDomu + next;
                next++;
            } else {
                break;
            }
        }
        return stacja;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        Arrays.sort(x);
        System.out.println(calculate(k,x));
    }
}
