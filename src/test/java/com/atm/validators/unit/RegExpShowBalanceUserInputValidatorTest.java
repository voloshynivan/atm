package com.atm.validators.unit;

import com.atm.validators.RegExpShowBalanceUserInputValidator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ivoloshyn on 7/19/2016.
 */
public class RegExpShowBalanceUserInputValidatorTest {
    @Test
    public void verifyRegExpShowBalanceUserInputValidatorTestPositive() {
        RegExpShowBalanceUserInputValidator regExpShowBalanceUserInputValidator = new RegExpShowBalanceUserInputValidator();
        assertTrue(regExpShowBalanceUserInputValidator.isValid("?"));
    }
}