package com.pranish.tic;

public class Value {
    private String value;
    private  int row;
    private  int column;

    public String getValue() {
       return value;
    }

    public void setValue(int value) {
        this.value = String.valueOf(value);

    }

    public void setValue(String value) {
        this.value = value;

    }

    public int getRow() {
        return row;
    }

    public Value setRow(int row) {
        this.row = row;
        return this;
    }

    public int getColumn() {
        return column;
    }

    public Value setColumn(int column) {
        this.column = column;
        return this;
    }
}
