package com.atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ivoloshyn on 5/22/2016.
 */
public class NewBalance {

    MoneyBox moneyBox = MoneyBox.getInstance();

    //the logic of changing the balance when user is adding Notes
    public void addNotes(String currency, int nominal, int number) {
        if (!moneyBox.currencyExists(currency)) {
            moneyBox.addCurrencyAndNotes(currency, nominal, number);
        } else {
            if (!moneyBox.noteExists(currency, nominal)) {
                moneyBox.addNotesToExistingCurrency(currency, nominal, number);
            } else {
                moneyBox.addNumberToCurrencyAndNominal(currency, nominal, number);
            }
        }
    }

    public void getCards(String currency, int amount, MoneyBox moneyBox){
        MinimumNotesAlgo algo = new MinimumNotesAlgo();
        algo.getCards(currency, amount, moneyBox);
        //// TODO: 5/22/2016 add smart usage of algorythm. Give it currency, amount and currentMoneyBox and let algorythm work on it;
    }


    public void printBalance() {
        for (HashMap.Entry<String, HashMap<Integer, Integer>> currency : moneyBox.getBalance().entrySet()) {
            for (HashMap.Entry<Integer, Integer> value : moneyBox.getBalance().get(currency.getKey()).entrySet()) {
                System.out.println(currency.getKey() + " " + value.getKey() + " " + value.getValue());
            }
        }
    }

}
