package com.pranish.tic;

import java.util.Scanner;
import static com.pranish.tic.CommonConst.*;

public class Processor {
    private Holder holder=null;
    ICounter countUserVsPc=null;
    Scanner scanner=null;
    public Processor(Holder holder) {
        this.holder=holder;
        this.countUserVsPc=new CountUserVsPc();
    }
    public  void printTicTacToeInFormat() {
        System.out.println("The item number are as Follows :\n");
        holder.printHolder();
        for (int g = 0; g < 4; g++) {
            System.out.println();
            System.out.println();
        }
    }

    public   void process() throws Exception {
        while (hasConditionMet()) {
            if (hasConditionMet()) {
                getSelectionFromUser();
            }
            printTicTacToeInFormat();
            if (hasConditionMet()) {
                getSelectionFromPc();
            }
            printTicTacToeInFormat();
        }
        printWinner();
    }
    private boolean hasConditionMet() throws Exception {
       return isEmpty()||hasCountMet();
    }

    private   void printWinner(){
        if (whoIsWinner() == DRAW) {
            System.out.println("No one Wins");
        } else if (whoIsWinner() == USER_WINNER) {
            System.out.println("You Win");
        } else if (whoIsWinner() == PC_WINNER) {
            System.out.println("Pc Wins");
        } else {
            System.out.println("No one Wins");
        }
    }

    private   void getSelectionFromPc() {
       getTitle(ITEM_PC);
        String holder = countUserVsPc.getNumber(this.holder);
        System.out.println("Pc selected -  " + holder);
        this.holder.putInPosition(Integer.parseInt(holder),PC_CHOICE);
    }

    private   void getSelectionFromUser() {
        getTitle(ITEM_USER);
       scanner = new Scanner(System.in);
        int selectedPosition = scanner.nextInt();
        this.holder.putInPosition(selectedPosition,X);
    }

    private void getTitle(int forUserOrPc) {
        if (forUserOrPc == ITEM_USER) {
            System.out.println("which item do you select.... (Write the number except X and 0)");
            System.out.println();
        }
        if (forUserOrPc == ITEM_PC) {
            System.out.println("Pc's turn.. ");
            System.out.println();
        }
    }

    private boolean isEmpty() throws Exception {
        if(this.holder==null)
            throw new Exception("Board not initialized");
        return this.holder.isEmpty();
    }

    private   boolean hasCountMet() {
        int totalNumberOfCount;
        String[] userOrPc = USER_AND_PC;
        boolean condition = true;
         for (int items = START; items < NUMBER_OF_ITEMS; items++) {
            for (int cases = START; cases < TOTAL_NO_OF_CASE; cases++) {
                totalNumberOfCount = countUserVsPc.setCaseAndCheck(this.holder, cases, userOrPc[items]);
                if (totalNumberOfCount == CommonConst.ALL_CHECKED_POSITIVE) {
                    condition = false;
                    break;
                }
            }
        }
        return condition;
    }

    private   int whoIsWinner() {
        int countRepeat;
        ICounter countUserVsPc = new CountUserVsPc();
        String[] f = USER_AND_PC;
        int winner = 0;
        for (int userOrPc = START; userOrPc < NUMBER_OF_ITEMS; userOrPc++) {
            for (int caseNumber = START; caseNumber < TOTAL_NO_OF_CASE; caseNumber++) {
                countRepeat = countUserVsPc.setCaseAndCheck(this.holder, caseNumber, f[userOrPc]);
                if (countRepeat == ALL_CHECKED_POSITIVE && f[userOrPc].equals(X)) {
                    winner = USER_WINNER;
                    break;
                }
                if (countRepeat == ALL_CHECKED_POSITIVE && f[userOrPc].equals(O)) {
                    winner = PC_WINNER;
                    break;
                }
            }
        }
        return winner;
    }
}
