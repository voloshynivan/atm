package com.atm.actions;

import com.atm.parsers.UserInputParser;
import com.atm.validators.RegExpPutUserInputValidator;

/**
 * Created by ivoloshyn on 6/8/2016.
 */
public class PutMoneyAction extends BaseAction {

    String failedMessage = "Validation failed: wrong format for putting money";

    public PutMoneyAction(String userInput) {
        super(userInput);
        validator = new RegExpPutUserInputValidator();
        super.setFailedMessage(failedMessage);
    }

    void doAction(String userInput) {
        moneyBox.putMoney(UserInputParser.getCurrency(userInput), UserInputParser.getNominal(userInput), UserInputParser.getNumber(userInput));
    }
}
