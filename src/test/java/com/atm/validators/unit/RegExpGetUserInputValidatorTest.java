package com.atm.validators.unit;

import com.atm.validators.RegExpGetUserInputValidator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ivoloshyn on 7/19/2016.
 */
public class RegExpGetUserInputValidatorTest {

    @Test
    public void verifyGetUserInputValidatorPositive(){
        RegExpGetUserInputValidator regExpGetUserInputValidator = new RegExpGetUserInputValidator();
        assertTrue(regExpGetUserInputValidator.isValid("- RUR 100"));
    }

}