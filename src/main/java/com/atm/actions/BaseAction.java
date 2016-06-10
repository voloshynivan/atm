package com.atm.actions;

import com.atm.logs.ILog;
import com.atm.logs.SOUTLog;
import com.atm.moneyBox.MoneyBox;
import com.atm.moneyBox.IMoneyBox;
import com.atm.validators.IUserInputValidator;

/**
 * Created by ivoloshyn on 6/8/2016.
 */
public abstract class BaseAction {
    IUserInputValidator validator;
    ILog log;
    IMoneyBox moneyBox;
    String userInput;
    String failedMessage;

    public BaseAction(String userInput) {
        this.userInput = userInput;
        log = new SOUTLog();
        moneyBox = new MoneyBox();
    }

    public void setFailedMessage(String failedMessage) {
        this.failedMessage = failedMessage;
    }

    public void execute() {
        if (validator.isValid(userInput)) {
            doAction(userInput);
        } else {
            log.log(this.failedMessage);
        }
    }

    abstract void doAction(String userInput);

}
