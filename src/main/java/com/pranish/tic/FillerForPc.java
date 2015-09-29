package com.pranish.tic;

import java.util.*;
import static com.pranish.tic.CommonConst.* ;


public class FillerForPc {
   private final String USER_CHOICE = X;
   private final String PC_CHOICE = O;
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
            List<FillerRowAndColumn> gapList=new ArrayList<FillerRowAndColumn>(0);
            for (int i = START; i < END; i++) {
                for (int j = START; j < END; j++) {
                    if (i == j) {
                        if (isEmpty(allArray[i][j])) {
                            FillerRowAndColumn fillerRowAndColumn=new FillerRowAndColumn();
                            fillerRowAndColumn.setRow(i);
                            fillerRowAndColumn.setColumn(j);
                            gapList.add(fillerRowAndColumn);
                        }
                    }
                }
            }
        int randomNumber=new Random().nextInt(gapList.size());
       int row = gapList.get(randomNumber).getRow();
       int column = gapList.get(randomNumber).getColumn();
        return  Integer.valueOf(allArray[row][column]);
    }

    private int getNumberIfAllOne(String[][] allArray){
         List<FillerRowAndColumn> list=new ArrayList<FillerRowAndColumn>(0);
        if (isEmpty(allArray[0][2])) {
            FillerRowAndColumn fillerRowAndColumn=new FillerRowAndColumn();
            fillerRowAndColumn.setRow(0);
            fillerRowAndColumn.setColumn(2);
            list.add(fillerRowAndColumn);
        }
        if (isEmpty(allArray[1][1])) {
            FillerRowAndColumn fillerRowAndColumn=new FillerRowAndColumn();
            fillerRowAndColumn.setRow(1);
            fillerRowAndColumn.setColumn(1);
            list.add(fillerRowAndColumn);
        }
        if (isEmpty(allArray[2][0])) {
            FillerRowAndColumn fillerRowAndColumn=new FillerRowAndColumn();
            fillerRowAndColumn.setRow(2);
            fillerRowAndColumn.setColumn(0);
            list.add(fillerRowAndColumn);
        }
        int rnd = new Random().nextInt(list.size());
        int row =list.get(rnd).getRow();
        int column = list.get(rnd).getColumn();
        return  Integer.valueOf(allArray[row][column]);
    }

    private int getNumberForNormalCases(String[][] allArray,RowAndColumn rowAndColumn){
        List<FillerRowAndColumn> gapList=new ArrayList<FillerRowAndColumn>(0);
        for (int i = rowAndColumn.getStartRow(); i <= rowAndColumn.getEndRow(); i++) {
            for (int j = rowAndColumn.getStartColumn(); j <= rowAndColumn.getEndColumn(); j++) {
                if (isEmpty(allArray[i][j])) {
                    FillerRowAndColumn fillerRowAndColumn=new FillerRowAndColumn();
                    fillerRowAndColumn.setRow(i);
                    fillerRowAndColumn.setColumn(j);
                    gapList.add(fillerRowAndColumn);
                }
            }
        }
        int rnd = new Random().nextInt(gapList.size());
        int row = gapList.get(rnd).getRow();
       int column = gapList.get(rnd).getColumn();
        return  Integer.valueOf(allArray[row][column]);
    }

    private boolean isEmpty(String position){
        if(!position.equals(USER_CHOICE)&&!position.equals(PC_CHOICE)){
            return true;
        }
        return false;
    }


}