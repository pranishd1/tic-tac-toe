package com.pranish.tic;

import java.util.Scanner;

import static com.pranish.tic.CommonConst.*;

/**
 * Created by quality on 9/27/2015.
 */
public class Processor {
    private String[][] allArray=new String[END][END];

    public void initializeArray(){
        String[][] allArray=new String[END][END];
        int numberForArray = START;
        for (int i = START; i < END; i++) {
            for (int j = START; j < END; j++) {
                numberForArray++;
                allArray[i][j] = String.valueOf(numberForArray);
            }
        }
       this.allArray=allArray;
    }

    public  void printTicTacToeInFormat() {
        String[][] tempArray=this.allArray;
        System.out.println("You need to write a number given except X and 0");
        System.out.println();
        System.out.println("X represent your selection and 0 is from PC");
        System.out.println();
        System.out.println("The item number are as Follows :\n");
        for (int i = START; i < END; i++) {
            for (int j = START; j < END; j++) {
                System.out.print("  " + tempArray[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
        for (int g = 0; g < 4; g++) {
            System.out.println();
            System.out.println();
        }

    }

    public boolean hasConditionMet(){
       if(isEmpty()&&hasCountMet()){
           return true;
       }
        return false;
    }

    public  void printWinner(){
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

    public   void process() {
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

    public  void getSelectionFromPc() {
        System.out.println("Pc's turn.. ");
        System.out.println();
        CountUserVsPc countUserVsPc = new CountUserVsPc();
        String holder = countUserVsPc.getNumber(allArray);
        System.out.println("Pc selected -  "+holder);
        for (int i = START; i < END; i++) {
            for (int j = START; j < END; j++) {
                if (allArray[i][j].equals((holder))) {
                    allArray[i][j] = O;
                }
            }
        }
    }

    public  void getSelectionFromUser() {
        Scanner s = new Scanner(System.in);
        System.out.println("which item do you select.... (Write the number except X and 0)");
        System.out.println();
        String first = String.valueOf(s.nextInt());
        for (int i = START; i < END; i++) {
            for (int j = START; j < END; j++) {
                if (allArray[i][j].equals((first))) {
                    allArray[i][j] = X;
                }
            }
        }


    }

    private boolean isEmpty(){
        String[][] tempArray=this.allArray;
        boolean check = false;
        for (int i = START; i < END; i++) {
            for (int j = START; j < END; j++) {
                if (!allArray[i][j].equals(X) && !tempArray[i][j].equals(O)) {
                    check = true;
                }
            }
        }
        return check;
    }

    private   boolean hasCountMet() {
        String[][] tempArray=this.allArray;
        int totalNumberOfCount;
        ICounter countUserVsPc = new CountUserVsPc();
        String[] userOrPc = USER_AND_PC;
        boolean condition = true;
        for (int items = START; items < NUMBER_OF_ITEMS; items++) {
            for (int cases = START; cases < TOTAL_NO_OF_CASE; cases++) {
                totalNumberOfCount = countUserVsPc.setCaseAndCheck(tempArray, cases, userOrPc[items]);
                if (totalNumberOfCount == CommonConst.ALL_CHECKED) {
                    condition = false;
                    break;
                }
            }
        }
        return condition;
    }

    private   int whoIsWinner() {
        String[][] tempArray=this.allArray;
        int countRepeat;
        ICounter countUserVsPc = new CountUserVsPc();
        String[] f = {X, O};
        int winner = 0;
        for (int userOrPc = START; userOrPc < NUMBER_OF_ITEMS; userOrPc++) {
            for (int caseNumber = START; caseNumber < TOTAL_NO_OF_CASE; caseNumber++) {
                countRepeat = countUserVsPc.setCaseAndCheck(tempArray, caseNumber, f[userOrPc]);
                if (countRepeat == ALL_CHECKED && f[userOrPc].equals(X)) {
                    winner = USER_WINNER;
                    break;
                }
                if (countRepeat == ALL_CHECKED && f[userOrPc].equals(O)) {
                    winner = PC_WINNER;
                    break;
                }
            }
        }
        return winner;
    }
}
