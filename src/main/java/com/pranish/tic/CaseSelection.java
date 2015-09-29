package com.pranish.tic;

import java.util.*;

import static com.pranish.tic.CommonConst.*;

public class CaseSelection {

    public static final int INVALID = 9;

    public int setPriorityForCases(int[][] allArray) {
        int[] caseNumber = new int[TOTAL_NO_OF_CASE];
        for (int caseItem = START; caseItem < TOTAL_NO_OF_CASE; caseItem++) {
            if (allArray[caseItem][ITEM_USER] == COUNT_ZERO && allArray[caseItem][ITEM_PC] == COUNT_TWO) {
                caseNumber[caseItem] = FIRST_CASE;
            } else if (allArray[caseItem][ITEM_USER] == COUNT_TWO && allArray[caseItem][ITEM_PC] == COUNT_ZERO) {
                caseNumber[caseItem] = SECOND_CASE;
            } else if (allArray[caseItem][ITEM_USER] == COUNT_ONE && allArray[caseItem][ITEM_PC] == COUNT_ZERO) {
                caseNumber[caseItem] = THIRD_CASE;
            } else if (allArray[caseItem][ITEM_USER] == COUNT_ONE && allArray[caseItem][ITEM_PC] == COUNT_ONE) {
                caseNumber[caseItem] = FORTH_CASE;
            } else if (allArray[caseItem][ITEM_USER] == COUNT_ZERO && allArray[caseItem][ITEM_PC] == COUNT_ZERO) {
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
        List<Integer> collectionOfHighest=new ArrayList<Integer>(0);
        for (int caseNumber = START; caseNumber < TOTAL_NO_OF_CASE; caseNumber++) {
            if (highestCaseStatus == caseStatus[caseNumber]) {
                collectionOfHighest.add(caseNumber);
            }
        }
        int finalDecidedCase = ZERO;
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