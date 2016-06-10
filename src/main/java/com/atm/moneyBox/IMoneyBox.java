package com.atm.moneyBox;

import com.atm.logs.ILog;

/**
 * Created by ivoloshyn on 6/9/2016.
 */
public interface IMoneyBox {
    void getMoney(String currency, int amount, ILog log);

    void putMoney(String currency, int nominal, int number);

    void showMoney(ILog log);
}
