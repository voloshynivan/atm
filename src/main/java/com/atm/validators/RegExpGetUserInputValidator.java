package com.atm.validators;

/**
 * Created by ivoloshyn on 6/8/2016.
 */
public class RegExpGetUserInputValidator extends RegExpBaseUserInputValidator {
    public String pattern = "\\-\\s[A-Z]{3}\\s\\d+";

    public RegExpGetUserInputValidator() {
        super.setPattern(pattern);
    }

}
