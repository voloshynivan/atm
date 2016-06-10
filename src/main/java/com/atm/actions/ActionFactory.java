package com.atm.actions;

import com.atm.actionIdentificators.IIdentifier;
import com.atm.logs.ILog;

/**
 * Created by ivoloshyn on 6/8/2016.
 */
public class ActionFactory {

    IIdentifier identifier;

    public ActionFactory(IIdentifier identifier) {
        this.identifier = identifier;
    }

    public BaseAction getAction(String userInput) {
        if (identifier.isPutMoneyAction(userInput)) {
            return new PutMoneyAction(userInput);
        }
        if (identifier.isGetMoneyAction(userInput)) {
            return new GetMoneyAction(userInput);
        }
        if (identifier.isShowBalanceAction(userInput)) {
            return new ShowBalanceAction(userInput);
        }

        return new ExplainMistakeAction(userInput);
    }
}
