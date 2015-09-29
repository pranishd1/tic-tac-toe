package com.pranish.tic;

/**
 * Created by quality on 9/27/2015.
 */
public abstract class CounterAbstact implements ICounter {
    public int countOccurance(String[][] allArray, int caseNumber, int itemNumber) {
        SetRowAndColumn setRowAndColumn=new SetRowAndColumn();
        return checkRowAndColumn(allArray, itemNumber, setRowAndColumn.getRowAndColumnForIndividualCase(caseNumber));
    }
    public   int setCaseAndCheck(String[][] allArray, int caseNumber, String itemName){
        SetRowAndColumn setRowAndColumn=new SetRowAndColumn();
       return checkRowAndColumn(allArray, itemName, setRowAndColumn.getRowAndColumnForIndividualCase(caseNumber));

    };
    public abstract String  getNumber(String[][] allArray);
    public abstract int checkRowAndColumn(String[][] allArray, int itemNumber, RowAndColumn rowAndColumn);
    public abstract int checkRowAndColumn(String[][] allArray, String itemName, RowAndColumn rowAndColumn);
}
