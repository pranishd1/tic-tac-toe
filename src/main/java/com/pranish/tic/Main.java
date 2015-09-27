package com.pranish.tic;

import java.util.Scanner;
import static com.pranish.tic.CommonConst.*;
public class Main {
    public static Scanner s = new Scanner(System.in);
    public static String[][] allArray = new String[3][3];

    public static void main(String[] args) {
      Processor processor=new Processor();
        processor.initializeArray();
        processor.printTicTacToeInFormat();
        processor.process();

      /* initializeArray();
        System.out.println("You need to write a number given except X and 0");
        System.out.println();
        System.out.println("X represent your selection and 0 is from PC");
        System.out.println();
        print_tic(allArray);
        process();*/
    }
    /*public static void initializeArray(){
        int numberForArray = START;
        for (int i = START; i < END; i++) {
            for (int j = START; j < END; j++) {
                numberForArray++;
                allArray[i][j] = String.valueOf(numberForArray);
            }
        }
    }
    public static void print_tic(String[][] allArray) {
        System.out.println("The item number are as Follows :\n");
        for (int i = START; i < END; i++) {
            for (int j = START; j < END; j++) {
                System.out.print("  " + allArray[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
        for (int g = 0; g < 4; g++) {
            System.out.println();
            System.out.println();
        }

    }
    private static void process() {
        while (empty()&& hasCountMet()) {

            if (empty() && hasCountMet()) {
                get_user();
            }
            print_tic(allArray);
            if (empty()  && hasCountMet()) {
                get_pc();
            }
            print_tic(allArray);
        }
        printWinner();
    }
    public static void printWinner(){
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
    public static int whoIsWinner() {
        int countRepeat;
        ICounter countUserVsPc = new CountUserVsPc();
        String[] f = {X, O};
        int winner = 0;
        for (int userOrPc = START; userOrPc < NUMBER_OF_ITEMS; userOrPc++) {
            for (int caseNumber = START; caseNumber < TOTAL_NO_OF_CASE; caseNumber++) {
                countRepeat = countUserVsPc.setCaseAndCheck(allArray, caseNumber, f[userOrPc]);
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
    public static boolean hasCountMet() {
        int x;
        ICounter countUserVsPc = new CountUserVsPc();
        String[] userOrPc = {X, O};
        boolean check = true;
        for (int j = START; j < 2; j++) {
            for (int i = START; i < TOTAL_NO_OF_CASE; i++) {
                x = countUserVsPc.setCaseAndCheck(allArray, i, userOrPc[j]);
                if (x == 3) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
    public static boolean empty() {
        boolean check = false;
        for (int i = START; i < END; i++) {
            for (int j = START; j < END; j++) {
                if (!allArray[i][j].equals(X) && !allArray[i][j].equals(O)) {
                    check = true;
                }
            }
        }
        return check;
    }
    public static void get_pc() {
        System.out.println("Pc's turn.. ");
        System.out.println();
        CountUserVsPc x = new CountUserVsPc();
        String hold = x.getNumber(allArray);
        for (int i = START; i < END; i++) {
            for (int j = START; j < END; j++) {
                if (allArray[i][j].equals((hold))) {
                    allArray[i][j] = O;
                }
            }
        }
    }
    public static void get_user() {
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


    }*/
}