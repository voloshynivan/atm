package com.atm.parsers;

/**
 * Created by ivoloshyn on 6/9/2016.
 */
public class UserInputParser {

    public static String getCurrency(String userInput){
        String[] parts = userInput.split(" ");
        return parts[1];
    }

    public static int getNominal(String userInput){
        String[] parts = userInput.split(" ");
        return Integer.parseInt(parts[2]);
    }

    public static int getNumber(String userInput){
        String[] parts = userInput.split(" ");
        return Integer.parseInt(parts[3]);
    }

    public static int getAmount(String userInput){
        String[] parts = userInput.split(" ");
        return Integer.parseInt(parts[2]);
    }

}
