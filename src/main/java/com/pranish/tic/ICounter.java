package com.pranish.tic;


public interface ICounter {
    int countOccurance(Holder holder, int caseNumber, int itemNumber);
    int setCaseAndCheck(Holder holder, int caseNumber, String itemName);
    int checkRowAndColumn(Holder holder, int itemNumber, RowAndColumn rowAndColumn);
    int checkRowAndColumn(Holder holder, String itemName, RowAndColumn rowAndColumn);
    String  getNumber(Holder holder);
}
