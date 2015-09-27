package com.pranish.tic;

import java.util.*;

import static com.pranish.tic.CommonConst.*;

public class CaseSelection {

    public static final int INVALID = 9;

    public int setPriorityForCases(int[][] allArray) {
        int[] caseNumber = new int[TOTAL_NO_OF_CASE];
        for (int caseItem = START; caseItem < TOTAL_NO_OF_CASE; caseItem++) {
            if (allArray[caseItem][ITEM_USER] == 0 && allArray[caseItem][ITEM_PC] == 2) {
                caseNumber[caseItem] = FIRST_CASE;
            } else if (allArray[caseItem][ITEM_USER] == 2 && allArray[caseItem][ITEM_PC] == 0) {
                caseNumber[caseItem] = SECOND_CASE;
            } else if (allArray[caseItem][ITEM_USER] == 1 && allArray[caseItem][ITEM_PC] == 0) {
                caseNumber[caseItem] = THIRD_CASE;
            } else if (allArray[caseItem][ITEM_USER] == 1 && allArray[caseItem][ITEM_PC] == 1) {
                caseNumber[caseItem] = FORTH_CASE;
            } else if (allArray[caseItem][ITEM_USER] == 0 && allArray[caseItem][ITEM_PC] == 0) {
                caseNumber[caseItem] = FIFTH_CASE;
            } else {
                caseNumber[caseItem] = SIXTH_CASE;
            }
        }
        return  filterCasePriorityStatus(caseNumber);
    }

    private int filterCasePriorityStatus(int[] caseStatus) {
        int highestCaseStatus = SIXTH_CASE;
        for (int caseItem = START; caseItem < TOTAL_NO_OF_CASE; caseItem++) {
            if (caseStatus[caseItem] < highestCaseStatus) {
                highestCaseStatus = caseStatus[caseItem];
            }
        }
        List<Integer> collectionOfHighest=new ArrayList();
        for (int caseNumber = START; caseNumber < TOTAL_NO_OF_CASE; caseNumber++) {
            if (highestCaseStatus == caseStatus[caseNumber]) {
                collectionOfHighest.add(caseNumber);
            }
        }
        int finalDecidedCase = 0;
        boolean checker = true;
        while (checker) {
            finalDecidedCase = getRandomNumberFromSpecifiedData(collectionOfHighest);
            if (finalDecidedCase != INVALID) {
                checker = false;
            }
        }
        return finalDecidedCase;
    }


    private int getRandomNumberFromSpecifiedData(List<Integer> caseStatus) {
        int rnd = new Random().nextInt(caseStatus.size());
        return caseStatus.get(rnd);

    }


}