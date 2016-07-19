package com.atm.parsers.unit;

import com.atm.parsers.UserInputParser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ivoloshyn on 7/19/2016.
 */
public class UserInputParserTest {
    @Test
    public void getCurrencyPositive() {
        UserInputParser userInputParser = new UserInputParser();
        assertEquals(userInputParser.getCurrency("+ RUR 10 20"), "RUR");
    }

    @Test
    public void getNominalPositive() {
        UserInputParser userInputParser = new UserInputParser();
        assertEquals(userInputParser.getNominal("+ RUR 10 20"), 10);
    }

    @Test
    public void getNumberPositive() {
        UserInputParser userInputParser = new UserInputParser();
        assertEquals(userInputParser.getNumber("+ RUR 10 20"), 20);
    }

    @Test
    public void getAmountPositive() {
        UserInputParser userInputParser = new UserInputParser();
        assertEquals(userInputParser.getAmount("- RUR 100"), 100);
    }

}