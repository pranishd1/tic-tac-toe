package com.pranish.tic;


  public   class FillerRowAndColumn{
        private int row;
        private int column;
    private String value;

    public String getValue() {
        return value;
    }

    public FillerRowAndColumn setValue(String value) {
        this.value = value;
        return this;
    }

    public int getRow() {
            return row;
        }

        public FillerRowAndColumn setRow(int row) {
            this.row = row;
            return this;
        }

        public int getColumn() {
            return column;
        }

        public FillerRowAndColumn setColumn(int column) {
            this.column = column;
            return this;
        }
    }

