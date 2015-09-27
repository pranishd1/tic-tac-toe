package com.pranish.tic;

import java.util.*;
import static com.pranish.tic.CommonConst.* ;
public class FillerForPc {
   private String userChoice = X;
   private String pcChoice = O;
   private int[] userOrPc = new int[2];
  private  int gap_count = 0;
    public int toFill(String[][] allArray,int caseNumber){
        SetRowAndColumn setRowAndColumn=new SetRowAndColumn();
      RowAndColumn rowAndColumn=setRowAndColumn.getRowAndColumnForIndividualCase(caseNumber);
       return makeChoiceByStatus(allArray,rowAndColumn);
    }

    private int makeChoiceByStatus(String[][] allArray,RowAndColumn rowAndColumn) {
        if (rowAndColumn.isAllSet(ZERO)) {
            return getNumberIfAllZero(allArray);
        } else if (rowAndColumn.isAllSet(ONE)) {
            return getNumberIfAllOne(allArray);
        } else {
            return getNumberForNormalCases(allArray,rowAndColumn);
        }
    }

    private int getNumberIfAllZero(String[][] allArray){

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
        return  Integer.valueOf(allArray[userOrPc[0]][userOrPc[1]]);
    }

    private int getNumberIfAllOne(String[][] allArray){
     /*   String userChoice = X;
        String pcChoice = O;
        int[] userOrPc = new int[2];
        int gap_count = 0;*/
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
        return  Integer.valueOf(allArray[userOrPc[0]][userOrPc[1]]);
    }

    private int getNumberForNormalCases(String[][] allArray,RowAndColumn rowAndColumn){
       /* String userChoice = X;
        String pcChoice = O;
        int[] userOrPc = new int[2];
        int gap_count = 0;*/
        for (int i = rowAndColumn.getStartRow(); i <= rowAndColumn.getEndRow(); i++) {
            for (int j = rowAndColumn.getStartColumn(); j <= rowAndColumn.getEndColumn(); j++) {
                if (!allArray[i][j].equals(userChoice) && !allArray[i][j].equals(pcChoice)) {
                    gap_count++;
                }
            }
        }
        int[][] gap_for = new int[gap_count][2];
        int w = 0;
        for (int i = rowAndColumn.getStartRow(); i <= rowAndColumn.getEndRow(); i++) {
            for (int j = rowAndColumn.getStartColumn(); j <= rowAndColumn.getEndColumn(); j++) {
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
        return  Integer.valueOf(allArray[userOrPc[0]][userOrPc[1]]);
    }


}