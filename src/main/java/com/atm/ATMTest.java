package com.atm;

import com.atm.actionIdentificators.IIdentifier;
import com.atm.actionIdentificators.IdentifierByFirstChar;
import com.atm.actions.ActionFactory;

import java.io.*;

public class ATMTest {

    public static void main(String[] args) throws IOException {
        IIdentifier identifier = new IdentifierByFirstChar();
        ActionFactory af = new ActionFactory(identifier);

        sayHi();
        String s;
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            af.getAction(s).execute();
        }
        sayBye();
    }

    //Just text to let user know that the program is started.
    public static void sayHi() {
        System.out.println("### Welcome to ATMTest.");
        System.out.println("### Please start using it by adding some money to it in format + <currency> <value> <number>  and press ENTER");
        System.out.println("### After it you will be able to take money back using format - <currency> <amount> and press ENTER");
        System.out.println("### If you want to close the program - just press ENTER");
    }

    //Letting user know that ATMTest is shutting down
    public static void sayBye() {
        System.out.println("Thank you for using ATMTest");
    }

}
