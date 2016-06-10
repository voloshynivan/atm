package com.atm.validators;

/**
 * Created by ivoloshyn on 6/9/2016.
 */
public abstract class RegExpBaseUserInputValidator implements IUserInputValidator {
    protected String pattern;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean isValid(String userInput) {
        return userInput.matches(pattern);
    }
}
