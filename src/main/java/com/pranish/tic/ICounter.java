package com.pranish.tic;

/**
 * Created by quality on 9/27/2015.
 */
public interface ICounter {
    int countOccurance(String[][] allArray, int caseNumber, int itemNumber);
    int setCaseAndCheck(String[][] allArray, int caseNumber, String itemName);
    int checkRowAndColumn(String[][] allArray, int itemNumber, RowAndColumn rowAndColumn);
    int checkRowAndColumn(String[][] allArray, String itemName, RowAndColumn rowAndColumn);
}
