package com.pranish.tic;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

import static com.pranish.tic.CommonConst.*;
public class CountUserVsPc extends CounterAbstact {

    @Override
    public  int countOccurance(Holder holder, int caseNumber, int itemNumber) {
        return checkRowAndColumn(holder, itemNumber, new SetRowAndColumn().getRowAndColumnForIndividualCase(caseNumber));
    }

    @Override
    public   int setCaseAndCheck(Holder holder, int caseNumber, String itemName){
        return checkRowAndColumn(holder, itemName, new SetRowAndColumn().getRowAndColumnForIndividualCase(caseNumber));
    };

    @Override
    public String getNumber(Holder holder) {
        if(isOverridable(holder)){
            return getOverRiddenNumber();
        }
        int[][] countUserOrPcInCase = new int[TOTAL_NO_OF_CASE][NUMBER_OF_ITEMS];
        for (int caseNumber = START; caseNumber < TOTAL_NO_OF_CASE; caseNumber++) {
            for (int userOrPc = START; userOrPc < NUMBER_OF_ITEMS; userOrPc++) {
                countUserOrPcInCase[caseNumber][userOrPc] = countOccurance(holder, caseNumber, userOrPc);
            }
        }
        CaseSelection caseSelection = new CaseSelection();
        int caseNumber = caseSelection.setPriorityForCases(countUserOrPcInCase);
        System.out.println();
        int toFill = 0;
        try {
            toFill = toFill(holder, caseNumber);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return String.valueOf(toFill);
    }

    @Override
    public int checkRowAndColumn(Holder holder, int itemNumber, RowAndColumn rowAndColumn) {
        if (itemNumber == ITEM_USER) {
            return holder.getCountForSingleCase(rowAndColumn.getCaseNumber(), ITEM_USER);
        }
        if (itemNumber == ITEM_PC) {
            return holder.getCountForSingleCase(rowAndColumn.getCaseNumber(),ITEM_PC);
        }
        return 0;
    }

    @Override
    public int checkRowAndColumn(Holder holder, String userOrPc, RowAndColumn rowAndColumn) {
        return holder.getCountForSingleCase(rowAndColumn.getCaseNumber(),userOrPc);
    }

    protected boolean isOverridable(Holder holder){
        return holder.getFive().getValue().equals(FIVE);
    }

    protected String getOverRiddenNumber(){
          return FIVE;
    }

    private int toFill(Holder holder,int caseNumber) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        SetRowAndColumn setRowAndColumn=new SetRowAndColumn();
        RowAndColumn rowAndColumn=setRowAndColumn.getRowAndColumnForIndividualCase(caseNumber);
        return makeChoiceByStatus(holder, rowAndColumn);
    }

    private int makeChoiceByStatus(Holder holder,RowAndColumn rowAndColumn) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<FillerRowAndColumn> rowAndColumns=holder.getEmptyCaseGaps(rowAndColumn.getCaseNumber());
        int randomNumber=new Random().nextInt(rowAndColumns.size());
        return  Integer.parseInt(rowAndColumns.get(randomNumber).getValue());
    }
}