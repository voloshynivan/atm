package com.company;

/**
 * Created by ivoloshyn on 4/11/2016.
 */
public class ATM {

    Handler handler = new Handler();

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

    //In this Method we are taking the user input and doing appropriate actions
    public void takeUserInput(String userInput){
        handler.handleInput(userInput);
    }

}
