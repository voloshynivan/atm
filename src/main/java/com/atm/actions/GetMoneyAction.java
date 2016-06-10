package com.atm.actions;

import com.atm.parsers.UserInputParser;
import com.atm.validators.RegExpGetUserInputValidator;

/**
 * Created by ivoloshyn on 6/8/2016.
 */
public class GetMoneyAction extends BaseAction {

    String failedMessage = "Validation failed: wrong format for getting money";

    public GetMoneyAction(String userInput) {
        super(userInput);
        validator = new RegExpGetUserInputValidator();
        super.setFailedMessage(failedMessage);
    }

    void doAction(String userInput){
        moneyBox.getMoney(UserInputParser.getCurrency(userInput), UserInputParser.getAmount(userInput), log);
    }

}
