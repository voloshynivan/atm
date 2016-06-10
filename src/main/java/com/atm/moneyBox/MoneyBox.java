package com.atm.moneyBox;

import com.atm.logs.ILog;
import com.atm.logs.SOUTLog;

import java.util.HashMap;

/**
 * Created by ivoloshyn on 6/9/2016.
 */
public class MoneyBox implements IMoneyBox {

    public static final String failToGetMoney = "It is not possible to get money with available notes";
    public static final String yourBalancePrefix = "Your balance is: ";


    MoneyStorageCollection moneyStorage = MoneyStorageCollection.getInstance();

    @Override
    public void getMoney(String currency, int amount, ILog log) {
        if (moneyStorage.isPossibleToRemoveMoney(currency, amount)) {
            moneyStorage.removeMoney(currency, amount);
        }
        log.log(failToGetMoney);
    }

    @Override
    public void putMoney(String currency, int nominal, int number) {
        moneyStorage.addMoney(currency, nominal, number);
    }

    @Override
    public void showMoney(ILog log) {
        for (HashMap.Entry<String, HashMap<Integer, Integer>> currency : moneyStorage.getBalance().entrySet()) {
            for (HashMap.Entry<Integer, Integer> value : moneyStorage.getBalance().get(currency.getKey()).entrySet()) {
                log.log(yourBalancePrefix + currency.getKey() + " " + value.getKey() + " " + value.getValue());
            }
        }
    }
}
