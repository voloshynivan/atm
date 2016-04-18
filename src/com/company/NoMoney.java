package com.company;

/**
 * Created by ivoloshyn on 4/11/2016.
 */
public class NoMoney implements State {
    ATM atm;

    public NoMoney(ATM atm){
        this.atm = atm;
    }

    @Override
    public void doPlus(int value){
        atm.setCount(atm.getCount() + value);
        atm.setState(atm.getHasMoneyState());
        System.out.println("Thank you for putting money. You balance is " + atm.getCount());
    }

    @Override
    public void doMinus(int value){
        System.out.println("Sorry, but you do not have money");
    }

}
