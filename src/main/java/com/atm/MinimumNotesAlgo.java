package com.atm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by ivoloshyn on 5/22/2016.
 */
public class MinimumNotesAlgo {

    //the logic of getting Money. Money should be taken from account only when possible
    public void getCards(String currency, int amount, MoneyBox moneyBox) {
        //If there is a try to get 0 - do nothing
        if (amount == 0) {
            System.out.println("Sorry - you wanted to get 0, we can give you nothing in this case");
        //If there is a chance to give money in 1 Note - do it
        } else if (moneyBox.noteExists(currency, amount)) {
            System.out.println("debug: please take money with one Note" + amount);
            moneyBox.takeOffOneNoteOfSomeCurrency(currency, amount);

        //it would be not possible to give money if we do not have small enough Notes. No need to start calculation we can already stop work
        } else if (amount % Collections.min(moneyBox.getListOfNotes(currency)) != 0) {
            System.out.println("Sorry, please try to type the amount of Money, which can be divided to: " + Collections.min(moneyBox.getListOfNotes(currency)));
            //if conditions above did not met - calculate the minimum amount of notes
        } else {
            List<Integer> moneyOnTheTable = moneyBox.getAllNotesForCurrency(currency);
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
                            moneyBox.takeOffOneNoteOfSomeCurrency(currency, note);
                            amount -= note;
                            break;
                        }
                    }
                }

            }

        }
    }
}
