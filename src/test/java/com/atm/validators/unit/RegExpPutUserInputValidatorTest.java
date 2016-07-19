package com.atm.validators.unit;

import com.atm.validators.RegExpPutUserInputValidator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ivoloshyn on 7/19/2016.
 */
public class RegExpPutUserInputValidatorTest {
    @Test
    public void verifyRegExpPutUserInputValidatorTestPositive() {
        RegExpPutUserInputValidator regExpPutUserInputValidator = new RegExpPutUserInputValidator();
        assertTrue(regExpPutUserInputValidator.isValid("+ RUR 10 20"));
    }
}