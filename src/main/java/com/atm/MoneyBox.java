package com.atm;

import java.util.*;

/**
 * Created by ivoloshyn on 5/22/2016.
 */
public class MoneyBox {

    private HashMap<String, HashMap<Integer, Integer>> currentBalance = new HashMap<String, HashMap<Integer, Integer>>();
    private MoneyBox(){};
    private static MoneyBox instance;

    public static MoneyBox getInstance(){
        if (instance == null){
            instance = new MoneyBox();
        }
        return instance;
    }


    public boolean currencyExists(String currency) {
        return currentBalance.containsKey(currency);
    }

    public boolean noteExists(String currency, int note) {
        return currentBalance.get(currency).containsKey(note);
    }

    public Map<String, HashMap<Integer, Integer>> getBalance(){
        return currentBalance;
    }

    public Map<String, HashMap<Integer, Integer>> addCurrencyAndNotes(String currency, int nominal, int number) {
        currentBalance.put(currency, new HashMap<Integer, Integer>(nominal, number));
        return currentBalance;
    }

    public Map<String, HashMap<Integer, Integer>> addNotesToExistingCurrency(String currency, int nominal, int number) {
        currentBalance.get(currency).put(nominal, number);
        return currentBalance;
    }

    public Map<String, HashMap<Integer, Integer>> addNumberToCurrencyAndNominal(String currency, int nominal, int number) {
        int currentNumber = currentBalance.get(currency).get(nominal);
        currentBalance.get(currency).put(nominal, currentNumber + number);
        return currentBalance;
    }

    public Map<String, HashMap<Integer, Integer>> takeOffOneNoteOfSomeCurrency(String currency, int nominal) {
        currentBalance.get(currency).put(nominal, currentBalance.get(currency).get(nominal)-1);
        removeNotesWithZeroNumbers(currency, nominal);
        return currentBalance;
    }

    public Set<Integer> getListOfNotes(String currency){
        return currentBalance.get(currency).keySet();
    }

    public List<Integer> getAllNotesForCurrency(String currency){
        List<Integer> allMoney = new ArrayList<Integer>();
        for (HashMap.Entry<Integer, Integer> value : currentBalance.get(currency).entrySet()) {
            for (int i = 0; i < value.getValue(); i++) {
                allMoney.add(value.getKey());
            }
        }
        return allMoney;
    }

    public int getTotalMoneyForCurrency(String currency){
        int totalMoneyForCurrency = 0;
        if (currencyExists(currency)){
            for (HashMap.Entry<Integer, Integer> valueNumber : getNotesAndNumbersForCurrency(currency).entrySet()) {
                totalMoneyForCurrency += valueNumber.getKey() * valueNumber.getValue();
            }
        }
        System.out.println("Total Money for " + currency + " on your account is " + totalMoneyForCurrency);
        return totalMoneyForCurrency;
    }


    public Map<Integer, Integer> getNotesAndNumbersForCurrency(String currency){
        return currentBalance.get(currency);
    }

    private Map<String, HashMap<Integer, Integer>> removeNotesWithZeroNumbers(String currency, int nominal) {
        if (currentBalance.get(currency).get(nominal) == 0){
            currentBalance.get(currency).remove(nominal);
        }
        return currentBalance;
    }

}
