package com.atm.validators;

/**
 * Created by ivoloshyn on 6/8/2016.
 */
public class RegExpPutUserInputValidator extends RegExpBaseUserInputValidator {
    public String pattern = "\\+\\s[A-Z]{3}\\s(1|5)0{0,3}\\s\\d+";

    public RegExpPutUserInputValidator(){
        super.setPattern(pattern);
    }
}
