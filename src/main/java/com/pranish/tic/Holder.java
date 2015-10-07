package com.pranish.tic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.pranish.tic.CommonConst.*;

public class Holder {
    private  String one="1";
    private   String two="2";
    private   String three="3";
    private   String four="4";
    private   String five="5";
    private  String six="6";
    private  String seven="7";
    private  String eight="8";
    private   String nine="9";
    private String _userOrPc;

    public  Value getOne() {
        Value value=new Value();
        value.setRow(0).setColumn(0).setValue(one);
        return value;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public  Value getTwo() {
        Value value=new Value();
        value.setRow(0).setColumn(1).setValue(two);
        return value;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public  Value getThree() {
        Value value=new Value();
        value.setRow(0).setColumn(2).setValue(three);
        return value;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public  Value getFour() {
        Value value=new Value();
        value.setRow(1).setColumn(0).setValue(four);
        return value;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public  Value getFive() {
        Value value=new Value();
        value.setRow(1).setColumn(1).setValue(five);
        return value;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public  Value getSix() {
        Value value=new Value();
        value.setRow(1).setColumn(2).setValue(six);
        return value;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public  Value getSeven() {
        Value value=new Value();
        value.setRow(2).setColumn(0).setValue(seven);
        return value;
    }

    public void setSeven(String seven) {
        this.seven = seven;
    }

    public  Value getEight() {
        Value value=new Value();
        value.setRow(2).setColumn(1).setValue(eight);
        return value;
    }

    public void setEight(String eight) {
        this.eight = eight;
    }

    public   Value getNine() {
        Value value=new Value();
        value.setRow(2).setColumn(2).setValue(nine);
        return value;
    }

    public void setNine(String nine) {
        this.nine = nine;
    }

    public String printHolder(){
        String formatted="";
        formatted+="  "+one+"  "+two+"  "+three+"\n";
        formatted+="  "+four+"  "+five+ "  "+six + "\n";
        formatted+="  "+seven+"  "+eight+"  "+nine+"\n";
        System.out.println(formatted);
        return formatted;
    }

    public  boolean isEmpty(){
        return checkForUserAndPc(one) && checkForUserAndPc(two) && checkForUserAndPc(three) &&
                checkForUserAndPc(four) && checkForUserAndPc(five) && checkForUserAndPc(six) &&
                checkForUserAndPc(seven) && checkForUserAndPc(eight) && checkForUserAndPc(nine);
    }

    public int getCountForSingleCase(int caseNumber,int userOrPc){
        if(userOrPc==ITEM_USER){
            return getCountForSingleCase(caseNumber,X);
        }
        if(userOrPc==ITEM_PC){
            return getCountForSingleCase(caseNumber,O);
        }
        return 0;
    }

    public int getCountForSingleCase(int caseNumber,String userOrPc){
        int count=0;
        this._userOrPc=userOrPc;
        switch (caseNumber){
            case 0:
               count=countForThree(one,two,three);
                break;
            case 1:
                count=countForThree(four,five,six);
                break;
            case 2:
                count=countForThree(seven,eight,nine);
                break;
            case 3:
                count=countForThree(one,four,seven);
                break;
            case 4:
                count=countForThree(two,five,eight);
                break;
            case 5:
                count=countForThree(three,six,nine);
                break;
            case 6:
                count=countForThree(one,five,nine);
                break;
            case 7:
                count=countForThree(three,five,seven);
                break;
        }
        return count;
    }

    public void putInPosition(int position,String choice){
        switch (position){
            case 1:
                if(one.equals(String.valueOf(position)))
                one=choice;
                break;
            case 2:
                if(two.equals(String.valueOf(position)))
                two=choice;
                break;
            case 3:
                if(three.equals(String.valueOf(position)))
                three=choice;
                break;
            case 4:
                if(four.equals(String.valueOf(position)))
                four=choice;
                break;
            case 5:
                if(five.equals(String.valueOf(position)))
                five=choice;
                break;
            case 6:
                if(six.equals(String.valueOf(position)))
                six=choice;
                break;
            case 7:
                if(seven.equals(String.valueOf(position)))
                seven=choice;
                break;
            case 8:
                if(eight.equals(String.valueOf(position)))
                eight=choice;
                break;
            case 9:
                if(nine.equals(String.valueOf(position)))
                nine=choice;
                break;
        }
    }


    public List< FillerRowAndColumn> getEmptyCaseGaps(int caseNumber) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        switch (caseNumber){
            case 0:
                return getAllGapList(Arrays.asList(one,two,three));
            case 1:
                return getAllGapList(Arrays.asList(four,five,six));
            case 2:
               return getAllGapList(Arrays.asList(seven,eight,nine));
            case 3:
                return getAllGapList(Arrays.asList(one,four,seven));
            case 4:
                return getAllGapList(Arrays.asList(two,five,eight));
            case 5:
                return getAllGapList(Arrays.asList(three,six,nine));
            case 6:
                return getAllGapList(Arrays.asList(one,five,nine));
            case 7:
                return getAllGapList(Arrays.asList(three,five,seven));
        }
        return new ArrayList<FillerRowAndColumn>(0);
    }

    private int countForThree(String first,String second,String third){
        int count=0;
        String userOrPc=this._userOrPc;
        count+=first.equals(userOrPc)?ONE:ZERO;
        count+=second.equals(userOrPc)?ONE:ZERO;
        count+=third.equals(userOrPc)?ONE:ZERO;
        return count;
    }

   private  boolean checkForUserAndPc(String choice){
       return !choice.equals(USER_CHOICE) && !choice.equals(PC_CHOICE);
   }

    private  List<FillerRowAndColumn> getAllGapList(List<String> allThreePositions) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List< FillerRowAndColumn> rowAndColumns=new ArrayList<FillerRowAndColumn>(0);
        for(int position=0;position<allThreePositions.size();position++) {
            if (checkForUserAndPc(allThreePositions.get(position))) {
                FillerRowAndColumn fillerRowAndColumn = new FillerRowAndColumn();
                String methodName=getValueFromMethod(allThreePositions.get(position));
               Value value = (Value) this.getClass().getDeclaredMethod(methodName).invoke(this,new Object[] {});
                fillerRowAndColumn.setRow(value.getRow()).setColumn(value.getColumn()).setValue(value.getValue());
                rowAndColumns.add(fillerRowAndColumn);
            }
        }
        System.out.println("Get All Gap List size:- "+rowAndColumns.size());
       return rowAndColumns;
    }

    private String getValueFromMethod(String position) throws NoSuchMethodException {
        String methodName=parseToMethodName(position,"get");
        System.out.println("get Value From Method - Method Name : "+methodName);
        return methodName;
    }

    private String parseToMethodName(String number,String state){
        String name=getNameFromNumber(number);
        return  state+String.valueOf(name.charAt(0)).toUpperCase()+name.substring(1,name.length());
    }

    private String getNameFromNumber(String number){
        int temp= Integer.parseInt(number);
        switch (temp){
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        return "";
    }
}
