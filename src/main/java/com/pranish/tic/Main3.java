package com.pranish.tic;

import java.util.*;
import static com.pranish.tic.CommonConst.* ;
public class Main3 {

    public int toFill(String[][] a, int cas) {
        int x = 0;
        switch (cas) {

            case 0:
                x = checkArray(a, 0, 0, 0, 2);
                break;
            case 1:
                x = checkArray(a, 1, 1, 0, 2);
                break;
            case 2:
                x = checkArray(a, 2, 2, 0, 2);
                break;
            case 3:
                x = checkArray(a, 0, 2, 0, 0);
                break;
            case 4:
                x = checkArray(a, 0, 2, 1, 1);
                break;
            case 5:
                x = checkArray(a, 0, 2, 2, 2);
                break;
            case 6:
                x = checkArray(a, 0, 0, 0, 0);//for diagonal1
                break;
            case 7:
                x = checkArray(a, 1, 1, 1, 1);//for diagonal2
                break;
            case 8:
                break;

        }

        return x;
    }

    public int checkArray(String[][] allArray, int s_row, int e_row, int s_col, int e_col) {
        String userChoice = X   ;
        String pcChoice = O;
        int[] userOrPc = new int[2];
        int gap_count = 0;

        if (s_row == 0 && e_row == 0 && s_col == 0 && e_col == 0) {

            for (int row = START; row < END; row++) {
                for (int column = START; column < END; column++) {
                    if (row == column) {
                        if (!allArray[row][column].equals(userChoice) && !allArray[row][column].equals(pcChoice)) {
                            gap_count++;
                        }
                    }
                }
            }


            int[][] gap_array = new int[gap_count][2];
            int w = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        if (!allArray[i][j].equals(userChoice) && !allArray[i][j].equals(pcChoice)) {
                            gap_array[w][0] = i;
                            gap_array[w][1] = j;
                            w++;
                        }
                    }
                }
            }
            int[] qw = new int[w];
            for (int i = 0; i < w; i++) {
                qw[i] = w;
            }
            int rnd = new Random().nextInt(qw.length);
            userOrPc[0] = gap_array[rnd][0];
            userOrPc[1] = gap_array[rnd][1];


        } else if (s_row == 1 && e_row == 1 && s_col == 1 && e_col == 1) {

            if (!allArray[0][2].equals(userChoice) && !allArray[0][2].equals(pcChoice)) {
                gap_count++;
                userOrPc[0] = 0;
                userOrPc[1] = 2;
            }
            if (!allArray[1][1].equals(userChoice) && !allArray[1][1].equals(pcChoice)) {
                gap_count++;
                userOrPc[0] = 1;
                userOrPc[1] = 1;
            }
            if (!allArray[2][0].equals(userChoice) && !allArray[2][0].equals(pcChoice)) {
                gap_count++;
                userOrPc[0] = 2;
                userOrPc[1] = 0;
            }


//starts from here in diagonal 2

            int[][] gap_array = new int[gap_count][2];
            int w = 0;

            if (!allArray[0][2].equals(userChoice) && !allArray[0][2].equals(pcChoice)) {
                gap_array[w][0] = 0;
                gap_array[w][1] = 2;
                w++;
            }
            if (!allArray[1][1].equals(userChoice) && !allArray[1][1].equals(pcChoice)) {
                gap_array[w][0] = 1;
                gap_array[w][1] = 1;
                w++;
            }
            if (!allArray[2][0].equals(userChoice) && !allArray[2][0].equals(pcChoice)) {
                gap_array[w][0] = 2;
                gap_array[w][1] = 0;
                w++;
            }


            int[] qw = new int[w];
            for (int i = 0; i < w; i++) {
                qw[i] = w;
            }
            int rnd = new Random().nextInt(qw.length);
            userOrPc[0] = gap_array[rnd][0];
            userOrPc[1] = gap_array[rnd][1];


//ends here for diagonal 2


        } else {

            for (int i = s_row; i <= e_row; i++) {
                for (int j = s_col; j <= e_col; j++) {

                    if (!allArray[i][j].equals(userChoice) && !allArray[i][j].equals(pcChoice)) {

                        gap_count++;
                    }

                }
            }

            int[][] gap_for = new int[gap_count][2];
            int w = 0;
            for (int i = s_row; i <= e_row; i++) {
                for (int j = s_col; j <= e_col; j++) {

                    if (!allArray[i][j].equals(userChoice) && !allArray[i][j].equals(pcChoice)) {
                        gap_for[w][0] = i;
                        gap_for[w][1] = j;
                        w++;
                    }

                }
            }
            int[] temp = new int[w];
            for (int u = 0; u < w; u++) {
                temp[u] = u;
            }
            int rnd = new Random().nextInt(temp.length);
            userOrPc[0] = gap_for[rnd][0];
            userOrPc[1] = gap_for[rnd][1];


        }


        return  Integer.valueOf(allArray[userOrPc[0]][userOrPc[1]]);



    }


}