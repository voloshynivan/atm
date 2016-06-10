package com.atm.actions;

/**
 * Created by ivoloshyn on 6/9/2016.
 */
public class ExplainMistakeAction extends BaseAction {

    public ExplainMistakeAction(String userInput) {
        super(userInput);
    }

    void doAction(String userInput) {
        log.log("ATM doesn't understand the operation based on your input: \"" + userInput + "\"");
    }

    @Override
    public void execute() {
        doAction(userInput);
    }
}
