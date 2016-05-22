package com.atm;

import java.io.*;

public class ATM {

    public static void main(String[] args) throws IOException {
        Handler handler = new Handler();
        sayHi();

        //InputStreamReader is used to read user input from command line
        String s;
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        while ((s = stdin.readLine()) != null && s.length()!=0){
        handler.handleInput(s);
        }

        sayBye();
    }

    //Just text to let user know that the program is started.
    public static void sayHi(){
        System.out.println("### Welcome to ATM.");
        System.out.println("### Please start using it by adding some money to it in format + <currency> <value> <number>  and press ENTER");
        System.out.println("### After it you will be able to take money back using format - <currency> <amount> and press ENTER");
        System.out.println("### If you want to close the program - just press ENTER");
    }

    //Letting user know that ATM is shutting down
    public static void sayBye(){
        System.out.println("Thank you for using ATM");
    }

}
