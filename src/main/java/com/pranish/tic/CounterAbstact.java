package com.pranish.tic;

public abstract class CounterAbstact implements ICounter {
    public  abstract int countOccurance(Holder holder, int caseNumber, int itemNumber);
    public  abstract int setCaseAndCheck(Holder holder, int caseNumber, String itemName);
    public abstract String  getNumber(Holder allArray);
    public abstract int checkRowAndColumn(Holder holder, int itemNumber, RowAndColumn rowAndColumn);
    public abstract  int checkRowAndColumn(Holder holder, String itemName, RowAndColumn rowAndColumn);
}
