package com.example.currencyconverter2;

public class Validator {

    public static boolean isInt(String Value ){
        try{
            Integer.parseInt(Value);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isDouble(String Value){
        try{
            Double.parseDouble(Value);
            return true;
        } catch (NumberFormatException e){
            return false;
        }

    }

}
