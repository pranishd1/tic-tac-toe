package com.pranish.tic;

public class SetRowAndColumn {
    public SetRowAndColumn(){

    }
    public SetRowAndColumn SetRowAndColumn(){
        return this;
    }
    public RowAndColumn getRowAndColumnForIndividualCase(int caseNumber) {
        RowAndColumn rowAndColumn=new RowAndColumn();
        switch (caseNumber) {
            case 0:
                rowAndColumn.setStartRow(0).setEndRow(0).setStartColumn(0).setEndColumn(2).setCaseNumber(0);
                break;
            case 1:
                rowAndColumn.setStartRow(1).setEndRow(1).setStartColumn(0).setEndColumn(2).setCaseNumber(1);
                break;
            case 2:
                rowAndColumn.setStartRow(2).setEndRow(2).setStartColumn(0).setEndColumn(2).setCaseNumber(2);
                break;
            case 3:
                rowAndColumn.setStartRow(0).setEndRow(2).setStartColumn(0).setEndColumn(0).setCaseNumber(3);
                break;
            case 4:
                rowAndColumn.setStartRow(0).setEndRow(2).setStartColumn(1).setEndColumn(1).setCaseNumber(4);
                break;
            case 5:
                rowAndColumn.setStartRow(0).setEndRow(2).setStartColumn(2).setEndColumn(2).setCaseNumber(5);
                break;
            case 6:
                rowAndColumn.setAll(0).setCaseNumber(6);
                break;
            case 7:
                rowAndColumn.setAll(1).setCaseNumber(7);
                break;
            case 8:
                break;
        }
        return rowAndColumn;
    }
}
