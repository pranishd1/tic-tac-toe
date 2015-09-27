package com.pranish.tic;

import java.util.*;

import static com.pranish.tic.CommonConst.START;
import static com.pranish.tic.CommonConst.TOTAL_NO_OF_CASE;

public class Main5 {

    public int tic_tac(int[][] x) {
        int[] cas = new int[TOTAL_NO_OF_CASE];
        for (int i = START; i < TOTAL_NO_OF_CASE; i++) {
            if (x[i][0] == 0 && x[i][1] == 2) {
                cas[i] = 1;
            } else if (x[i][0] == 2 && x[i][1] == 0) {
                cas[i] = 2;
            } else if (x[i][0] == 1 && x[i][1] == 0) {
                cas[i] = 3;
            } else if (x[i][0] == 1 && x[i][1] == 1) {
                cas[i] = 4;
            } else if (x[i][0] == 0 && x[i][1] == 0) {
                cas[i] = 5;
            } else {
                cas[i] = 6;
            }
        }

        int cas_nu = cas_for(cas);
        return cas_nu;

    }

    public int cas_for(int[] x) {
        int min_cas = 6;
        for (int i = 0; i < 8; i++) {
            if (x[i] < min_cas) {
                min_cas = x[i];
            }
        }
        int same_min = 0;
        for (int i = 0; i < 8; i++) {
            if (min_cas == x[i]) {
                same_min++;
            }
        }
        int[] temp_min = new int[same_min];
        int ww = 0;
        for (int i = 0; i < 8; i++) {
            if (min_cas == x[i]) {
                temp_min[ww] = i;
                ww++;
            }
        }
        int fina = 0;
        boolean cc = true;
        while (cc == true) {
            fina = random(temp_min);
            if (fina != 9) {
                cc = false;
            }
        }


        return fina;
    }

    public int random(int[] x) {
        int rnd = new Random().nextInt(x.length);
        return x[rnd];

    }


}