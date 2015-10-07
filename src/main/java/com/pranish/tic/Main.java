package com.pranish.tic;

public class Main {
     public static void main(String[] args) throws Exception {
        Holder gameBox=new Holder();
        Processor processor=new Processor(gameBox);
        processor.printTicTacToeInFormat();
        processor.process();
    }
}