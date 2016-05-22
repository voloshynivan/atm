package com.atm;

/**
 * Created by ivoloshyn on 4/23/2016.
 */
public  class Handler {

    Balance balance = new Balance();

    public void handleInput(String userInput){
        System.out.println("You've tried to enter \"" + userInput + "\"");

        if (userInput.startsWith("-")) handleMinus(userInput);
        else if (userInput.startsWith("+")) handlePlus(userInput);
        else if (userInput.startsWith("?")) handleBalance();
        else System.out.println("Sorry, you have type the command in incorrect format. Please make sure it is started from \"+\" or \"-\"");

    }

    private void handlePlus(String userInput){
        if (!userInput.matches("\\+\\s[A-Z]{3}\\s(1|5)0{0,3}\\s\\d+")) {
            System.out.println("Sorry, the format for adding money to machine is not correct. It should be + <currency> <value> <number>");
        } else {
            String[] parts = userInput.split(" ");
            String currency = parts[1];
            int value = Integer.parseInt(parts[2]);
            int number = Integer.parseInt(parts[3]);
            balance.addNotes(currency, value, number);
            System.out.println("OK");
            System.out.println("You've successfully added " + value*number + " " + currency + "s");
        }

    }

    private void handleMinus(String userInput){
        if (!userInput.matches("\\-\\s[A-Z]{3}\\s\\d+")) {
            System.out.println("Sorry, the format for getting money from machine is not correct. It should be - <currency> <amount>");
        } else {
            String[] parts = userInput.split(" ");
            String currency = parts[1];
            int amount = Integer.parseInt(parts[2]);
            if (balance.getTotalMoneyForCurrency(currency)>=amount){
                balance.getCards(currency, amount);
                System.out.println("OK");
            } else {
                System.out.println("ERROR");
                System.out.println("You do not have enough money to get " + amount + " " + currency + "s");
            }
        }
    }

    private void handleBalance(){
        System.out.println("Your balance is..");
        balance.printBalance();
    }

}
