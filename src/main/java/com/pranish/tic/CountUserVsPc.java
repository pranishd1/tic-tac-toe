package com.pranish.tic;
import static com.pranish.tic.CommonConst.*;
public class CountUserVsPc extends CounterAbstact {

    @Override
    public String getNumber(String[][] allArray) {
        int[][] countUserOrPcInCase = new int[TOTAL_NO_OF_CASE][NUMBER_OF_ITEMS];
        for (int caseNumber = START; caseNumber < TOTAL_NO_OF_CASE; caseNumber++) {
            for (int userOrPc = START; userOrPc < NUMBER_OF_ITEMS; userOrPc++) {
                countUserOrPcInCase[caseNumber][userOrPc] = countOccurance(allArray, caseNumber, userOrPc);
            }
        }
        CaseSelection caseSelection = new CaseSelection();
        int tem = caseSelection.setPriorityForCases(countUserOrPcInCase);
        System.out.println();
        Main3 f = new Main3();
        int tofill = f.toFill(allArray, tem);
        return String.valueOf(tofill);
    }

    @Override
    public int checkRowAndColumn(String[][] allArray, int itemNumber, RowAndColumn rowAndColumn) {
        String userChoice = X;
        String pcChoice = O;
        int userCount = 0;
        int pcCount = 0;

        if (rowAndColumn.isAllSet(0)) {
            for (int row = START; row < END; row++) {
                for (int column = START; column < END; column++) {

                    if (row == column && itemNumber == ITEM_USER) {
                        if (allArray[row][column].equals(userChoice)) {
                            userCount++;
                        }
                    }

                    if (row == column && itemNumber == ITEM_PC) {
                        if (allArray[row][column].equals(pcChoice)) {
                            pcCount++;
                        }
                    }

                }
            }


        } else if (rowAndColumn.isAllSet(1)) {

            if (allArray[0][2].equals(userChoice)) {
                userCount++;
            }
            if (allArray[0][2].equals(pcChoice)) {
                pcCount++;
            }
            if (allArray[1][1].equals(userChoice)) {
                userCount++;
            }
            if (allArray[1][1].equals(pcChoice)) {
                pcCount++;
            }
            if (allArray[2][0].equals(userChoice)) {
                userCount++;
            }
            if (allArray[2][0].equals(pcChoice)) {
                pcCount++;
            }

        } else {

            for (int i = rowAndColumn.getStartRow(); i <= rowAndColumn.getEndRow(); i++) {
                for (int j = rowAndColumn.getStartColumn(); j <= rowAndColumn.getEndColumn(); j++) {

                    if (allArray[i][j].equals(userChoice)) {
                        userCount++;
                    }
                    if (allArray[i][j].equals(pcChoice)) {
                        pcCount++;
                    }

                }
            }

        }

        if (itemNumber == 0) {
            return userCount;
        }
        if (itemNumber == 1) {
            return pcCount;
        }
        return 0;

    }

    @Override
    public int checkRowAndColumn(String[][] matrixArray, String userOrPc, RowAndColumn rowAndColumn) {
        int count = 0;
        if (rowAndColumn.isAllSet(0)) {
            if (matrixArray[0][0].equals(userOrPc) && matrixArray[1][1].equals(userOrPc) && matrixArray[2][2].equals(userOrPc)) {
                count = 3;
            }
        } else if (rowAndColumn.isAllSet(1)) {
            if (matrixArray[0][2].equals(userOrPc) && matrixArray[1][1].equals(userOrPc) && matrixArray[2][0].equals(userOrPc)) {
                count = 3;
            }
        } else {
            for (int i = rowAndColumn.getStartRow(); i <= rowAndColumn.getEndRow(); i++) {
                for (int j = rowAndColumn.getStartColumn(); j <= rowAndColumn.getEndColumn(); j++) {
                    if (matrixArray[i][j].equals(userOrPc)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    public int  setCaseAndCheck(String[][] allArray, int caseNumber, String itemName) {
        SetRowAndColumn setRowAndColumn=new SetRowAndColumn();
        return checkRowAndColumn(allArray, itemName, setRowAndColumn.getRowAndColumnForIndividualCase(caseNumber));

    }

}