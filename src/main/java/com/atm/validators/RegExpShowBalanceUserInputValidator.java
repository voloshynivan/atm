package com.atm.validators;

/**
 * Created by ivoloshyn on 6/8/2016.
 */
public class RegExpShowBalanceUserInputValidator extends RegExpBaseUserInputValidator {
    public String pattern = "\\?";

    public RegExpShowBalanceUserInputValidator(){
        super.setPattern(pattern);
    }
}
