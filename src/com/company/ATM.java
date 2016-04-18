package com.company;

/**
 * Created by ivoloshyn on 4/11/2016.
 */
public class ATM {

    State noMoneyState;
    State hasMoneyState;

    State state = noMoneyState;
    int count = 0;

    public ATM(int number){
        noMoneyState = new NoMoney(this);
        hasMoneyState = new HasMoney(this);
        this.count = number;
        if (number > 0) {
            state = hasMoneyState;
        } else {
            state = noMoneyState;
        }
    }

    public void setState (State state){
        this.state = state;
    }

    public void doPlus(int value){
        state.doPlus(value);
    }

    public void doMinus(int value){
        state.doMinus(value);
    }

    public State getHasMoneyState (){
        return this.hasMoneyState;
    }

    public State getNoMoneyState (){
        return this.noMoneyState;
    }

    public int getCount (){
        return this.count;
    }

    public void setCount (int count){
        this.count = count;
    }
}
