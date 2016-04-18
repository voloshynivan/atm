package com.company;

/**
 * Created by ivoloshyn on 4/11/2016.
 */
public class HasMoney implements State {
    ATM atm;

    public HasMoney(ATM atm){
        this.atm = atm;
    }

    @Override
    public void doPlus(int value){
        atm.setCount(atm.getCount() + value);
        System.out.println("Thank you for putting money. You balance is " + atm.getCount());
    }

    @Override
    public void doMinus(int value){
        if(atm.getCount() < value) {
            System.out.println("Sorry, you do not have enough money on your account to cash out " + value + ", current balance is " + atm.getCount());
        } else {
            System.out.println("Your balance is going to be decreased by " + value);
            atm.setCount(atm.getCount() - value);
            System.out.println("Your current balance is " + atm.getCount());
        }

        if(atm.getCount()<=0) {
            System.out.println("You have no enough money to be taken from your account");
            atm.setState(atm.getNoMoneyState());
        }
    }
}
