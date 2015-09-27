package com.pranish.tic;

public class FinalChecker extends CounterAbstact {

    @Override
    public int  setCaseAndCheck(String[][] allArray, int caseNumber, String itemName) {
        SetRowAndColumn setRowAndColumn=new SetRowAndColumn();
        return checkRowAndColumn(allArray, itemName, setRowAndColumn.getRowAndColumnForIndividualCase(caseNumber));

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
    public int checkRowAndColumn(String[][] allArray, int itemNumber, RowAndColumn rowAndColumn) {
        return 0;
    }


}