package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ATM atm = new ATM();

        atm.sayHi();

        //InputStreamReader is used to read user input from command line
        String s;
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        while ((s = stdin.readLine()) != null && s.length()!=0){
            atm.takeUserInput(s);
        }

        atm.sayBye();

    }

}
