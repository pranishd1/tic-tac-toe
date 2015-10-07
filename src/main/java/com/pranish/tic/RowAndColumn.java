package com.pranish.tic;

public class RowAndColumn {
    private int startRow=0;
    private int endRow=0;
    private int startColumn=0;
    private int endColumn=0;
    private int caseNumber=0;

    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public int getStartRow() {
        return startRow;
    }

    public RowAndColumn setStartRow(int startRow) {
        this.startRow = startRow;
        return this;
    }

    public int getEndRow() {
        return endRow;
    }

    public RowAndColumn setEndRow(int endRow) {
        this.endRow = endRow;
        return this;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public RowAndColumn setStartColumn(int startColumn) {
        this.startColumn = startColumn;
        return this;
    }

    public int getEndColumn() {
        return endColumn;
    }

    public RowAndColumn setEndColumn(int endColumn) {
        this.endColumn = endColumn;
        return this;
    }

    public RowAndColumn setAll(int allValue){
        this.startRow=allValue;
        this.endRow=allValue;
        this.startColumn=allValue;
        this.endColumn=allValue;
        return this;
    }

    public boolean isAllSet(int checkValue){
        if(this.startRow==checkValue&&this.endRow==checkValue&&this.startColumn==checkValue&&this.endColumn==checkValue){
            return true;
        }
        return false;
    }




}
