package com.atm.actionIdentificators;

/**
 * Created by ivoloshyn on 6/9/2016.
 */
public class IdentifierByFirstChar implements IIdentifier {
    public static final String putMoneyIdentifier = "+";
    public static final String getMoneyIdentifier = "-";
    public static final String showBalanceIdentifier = "?";

    @Override
    public boolean isGetMoneyAction(String userInput) {
        return userInput.startsWith(getMoneyIdentifier);
    }

    @Override
    public boolean isPutMoneyAction(String userInput) {
        return userInput.startsWith(putMoneyIdentifier);
    }

    @Override
    public boolean isShowBalanceAction(String userInput) {
        return userInput.startsWith(showBalanceIdentifier);
    }
}
