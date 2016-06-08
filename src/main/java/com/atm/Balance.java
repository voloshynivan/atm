package com.atm;

import java.util.*;

/**
 * Created by ivoloshyn on 4/23/2016.
 */
public class Balance {

    HashMap<String, HashMap<Integer, Integer>> currentBalance = new HashMap<String, HashMap<Integer, Integer>>();

    //the logic of changing the balance when user is adding Notes
    public void addNotes(String currency, int value, int number) {
        if (!getCurrentBalance().containsKey(currency)) {
            HashMap<Integer, Integer> valueNumber = new HashMap<Integer, Integer>();
            valueNumber.put(value, number);
            getCurrentBalance().put(currency, valueNumber);
        } else {
            if (!getCurrentBalance().get(currency).containsKey(value)) {
                getCurrentBalance().get(currency).put(value, number);
            } else {
                int currentNumber = getCurrentBalance().get(currency).get(value);
                getCurrentBalance().get(currency).put(value, currentNumber + number);
            }
        }
    }

    //the logic of getting Money. Money should be taken from account only when possible
    public void getCards(String currency, int amount) {
        //If there is a try to get 0 - do nothing
        if (amount == 0) {
            System.out.println("Sorry - you wanted to get 0, we can give you nothing in this case");
            //If there is a chance to give money in 1 Note - do it
        } else if (getCurrentBalance().get(currency).containsKey(amount)) {
            System.out.println("debug: please take money with one Note" + amount);
            getCurrentBalance().get(currency).put(amount, getCurrentBalance().get(currency).get(amount) - 1);
            if (getCurrentBalance().get(currency).get(amount) == 0) {
                getCurrentBalance().get(currency).remove(amount);
            }

            //it would be not possible to give money if we do not have small enough Notes. No need to start calculation we can already stop work
        } else if (amount % Collections.min(getCurrentBalance().get(currency).keySet()) != 0) {
            System.out.println("Sorry, please try to type the amount of Money, which can be divided to: " + Collections.min(getCurrentBalance().get(currency).keySet()));
            //if conditions above did not met - calculate the minimum amount of notes
        } else {
            List<Integer> moneyOnTheTable = putMoneyOnTheTable(getCurrentBalance().get(currency));
            int inf = 1000000000;
            int f[] = new int[amount + 1];
            f[0] = 0;
            for (int cash = 1; cash <= amount; ++cash) {
                f[cash] = inf;
                for (int note : moneyOnTheTable) {
                    if (cash >= note && f[cash - note] + 1 < f[cash]) {
                        f[cash] = f[cash - note] + 1;
                    }
                }
            }
            if (f[amount] == inf) {
                System.out.println("It is not possible to get money with available notes");
            } else {
                while (amount > 0) {
                    for (int note : moneyOnTheTable) {
                        if (amount >= note && f[amount - note] == f[amount] - 1) {
                            System.out.println("take note: " + note);
                            getCurrentBalance().get(currency).put(note, getCurrentBalance().get(currency).get(note) - 1);
                            if (getCurrentBalance().get(currency).get(note) == 0) {
                                getCurrentBalance().get(currency).remove(note);
                            }
                            amount -= note;
                            break;
                        }
                    }
                }

            }

        }
    }

    public void printBalance() {
        for (HashMap.Entry<String, HashMap<Integer, Integer>> currency : getCurrentBalance().entrySet()) {
            for (HashMap.Entry<Integer, Integer> value : getCurrentBalance().get(currency.getKey()).entrySet()) {
                System.out.println(currency.getKey() + " " + value.getKey() + " " + value.getValue());
            }
        }
    }

    public int getTotalMoneyForCurrency(String currency) {
        int totalMoneyForCurrency = 0;
        if (getCurrentBalance().containsKey(currency)) {
            for (HashMap.Entry<Integer, Integer> valueNumber : getCurrentBalance().get(currency).entrySet()) {
                totalMoneyForCurrency += valueNumber.getKey() * valueNumber.getValue();
            }
        }
        System.out.println("Total Money for " + currency + " on your account is " + totalMoneyForCurrency);

        return totalMoneyForCurrency;
    }

    //creates and Array for holding all Money which we have in the ATM
    private List<Integer> putMoneyOnTheTable(HashMap<Integer, Integer> valueNumber) {
        List<Integer> allMoney = new ArrayList<Integer>();
        for (HashMap.Entry<Integer, Integer> value : valueNumber.entrySet()) {
            for (int i = 0; i < value.getValue(); i++) {
                allMoney.add(value.getKey());
            }
        }
        return allMoney;
    }

    private HashMap<String, HashMap<Integer, Integer>> getCurrentBalance() {
        return this.currentBalance;
    }


}
