package com.atm.actionIdentificators;

/**
 * Created by ivoloshyn on 6/9/2016.
 */
public interface IIdentifier {
    boolean isGetMoneyAction(String userInput);

    boolean isPutMoneyAction(String userInput);

    boolean isShowBalanceAction(String userInput);
}
