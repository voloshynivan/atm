package com.atm.algorithm;

import com.atm.logs.ILog;
import com.atm.moneyBox.MoneyStorageCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivoloshyn on 6/10/2016.
 */
public class MinimumNotesAlgo implements IAlgo {

    private static final int infinity = 1000000000;

    @Override
    public void removeMoney(Map<String, HashMap<Integer, Integer>> currentBalance, String currency, int amount) {
        int f[] = bottomUpArray(currentBalance, currency, amount);
        while (amount > 0) {
            for (int note : getAllNotesForCurrency(currentBalance, currency)) {
                if (amount >= note && f[amount - note] == f[amount] - 1) {
                    System.out.println("debug: take note: " + note);
                    MoneyStorageCollection.getInstance().removeOneNumber(currency, note);
                    amount -= note;
                    break;
                }
            }
        }

    }

    @Override
    public boolean isAlgorithmPossible(Map<String, HashMap<Integer, Integer>> currentBalance, String currency, int amount) {
        int f[] = bottomUpArray(currentBalance, currency, amount);
        if (f[amount] == infinity) {
            return false;
        } else {
            return true;
        }
    }

    private int[] bottomUpArray(Map<String, HashMap<Integer, Integer>> currentBalance, String currency, int amount) {
        int f[] = new int[amount + 1];
        f[0] = 0;
        for (int cash = 1; cash <= amount; ++cash) {
            f[cash] = infinity;
            for (int note : getAllNotesForCurrency(currentBalance, currency)) {
                if (cash >= note && f[cash - note] + 1 < f[cash]) {
                    f[cash] = f[cash - note] + 1;
                }
            }
        }
        return f;
    }

    private List<Integer> getAllNotesForCurrency(Map<String, HashMap<Integer, Integer>> currentBalance, String currency) {
        List<Integer> allMoney = new ArrayList<Integer>();
        for (HashMap.Entry<Integer, Integer> value : currentBalance.get(currency).entrySet()) {
            for (int i = 0; i < value.getValue(); i++) {
                allMoney.add(value.getKey());
            }
        }
        return allMoney;
    }
}
