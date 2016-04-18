package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        ATM atm = new ATM(0);
        System.out.println(atm);
        atm.doMinus(2);
        atm.doPlus(10);
        atm.doMinus(8);
        atm.doMinus(8);




/*
        try{
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            System.out.println("Please enter any string::");
            String inputString = br.readLine();
            if (inputString.startsWith("+")) {
                System.out.println("You Entered ::" + inputString);
            } else {
                System.out.println("something bad happened");
            }
        } catch (Exception IO){

        }
*/
    }


}
