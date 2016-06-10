package com.atm.moneyBox;

import com.atm.algorithm.*;
import com.atm.algorithm.MinimumNotesAlgo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivoloshyn on 6/9/2016.
 */
public class MoneyStorageCollection {
    private HashMap<String, HashMap<Integer, Integer>> currentBalance = new HashMap<String, HashMap<Integer, Integer>>();
    private static MoneyStorageCollection instance;
    private IAlgo algo;

    private MoneyStorageCollection(IAlgo algo) {
        this.algo = algo;
    }

    public static MoneyStorageCollection getInstance() {
        if (instance == null) {
            instance = new MoneyStorageCollection(new MinimumNotesAlgo());
        }
        return instance;
    }

    public void addMoney(String currency, int nominal, int number) {
        initCurrency(currency);
        if (!isNominalPresent(currency, nominal)) {
            addNominalAndNumber(currency, nominal, number);
        } else {
            addNumberToExistingNominal(currency, nominal, number);
        }
    }

    public void removeOneNumber(String currency, int nominal) {
        currentBalance.get(currency).put(nominal, currentBalance.get(currency).get(nominal) - 1);
        removeNominalWithZeroNumber(currency, nominal);
    }

    public boolean isPossibleToRemoveMoney(String currency, int amount) {
        if (amount <= getTotalMoneyForCurrency(currency)) {
            return algo.isAlgorithmPossible(currentBalance, currency, amount);
        } else {
            return false;
        }
    }

    public void removeMoney(String currency, int amount) {
        algo.removeMoney(currentBalance, currency, amount);
    }

    public Map<String, HashMap<Integer, Integer>> getBalance() {
        return currentBalance;
    }

    private boolean isCurrencyPresent(String currency) {
        if (currentBalance.get(currency) == null) {
            return false;
        } else {
            return true;
        }
    }

    private void initCurrency(String currency) {
        if (!isCurrencyPresent(currency)) {
            currentBalance.put(currency, new HashMap<Integer, Integer>());
        }
    }

    private boolean isNominalPresent(String currency, int nominal) {
        if (currentBalance.get(currency).get(nominal) == null) {
            return false;
        } else {
            return true;
        }
    }

    private void addNominalAndNumber(String currency, int nominal, int number) {
        currentBalance.get(currency).put(nominal, number);
    }

    private void addNumberToExistingNominal(String currency, int nominal, int number) {
        int currentNumber = currentBalance.get(currency).get(nominal);
        currentBalance.get(currency).put(nominal, currentNumber + number);
    }

    private void removeNominalWithZeroNumber(String currency, int nominal) {
        if (currentBalance.get(currency).get(nominal) == 0) {
            currentBalance.get(currency).remove(nominal);
        }
    }

    private int getTotalMoneyForCurrency(String currency) {
        int totalMoneyForCurrency = 0;
        if (isCurrencyPresent(currency)) {
            for (HashMap.Entry<Integer, Integer> valueNumber : currentBalance.get(currency).entrySet()) {
                totalMoneyForCurrency += valueNumber.getKey() * valueNumber.getValue();
            }
        }
        return totalMoneyForCurrency;
    }
}
