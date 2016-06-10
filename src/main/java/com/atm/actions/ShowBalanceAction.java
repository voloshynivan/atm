package com.atm.actions;

import com.atm.validators.RegExpShowBalanceUserInputValidator;

/**
 * Created by ivoloshyn on 6/8/2016.
 */
public class ShowBalanceAction extends BaseAction {

    String failedMessage = "Validation failed: wrong format for showing balance";

    public ShowBalanceAction(String userInput) {
        super(userInput);
        validator = new RegExpShowBalanceUserInputValidator();
        super.setFailedMessage(failedMessage);
    }

    void doAction(String userInput) {
        moneyBox.showMoney(log);
    }
}
