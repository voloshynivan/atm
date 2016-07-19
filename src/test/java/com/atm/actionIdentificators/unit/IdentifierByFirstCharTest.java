package com.atm.actionIdentificators.unit;

import com.atm.actionIdentificators.IdentifierByFirstChar;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ivoloshyn on 7/18/2016.
 */
public class IdentifierByFirstCharTest {

    @Test
    public void isGetMoneyActionPositive() {
        IdentifierByFirstChar identifierByFirstChar = new IdentifierByFirstChar();
        assertTrue(identifierByFirstChar.isGetMoneyAction("- RUR 100"));
    }

    @Test
    public void isGetMoneyActionStartFromNumber() {
        IdentifierByFirstChar identifierByFirstChar = new IdentifierByFirstChar();
        assertFalse(identifierByFirstChar.isGetMoneyAction("1 RUR 100"));
    }

    @Test
    public void isGetMoneyActionStartFromApostrophe() {
        IdentifierByFirstChar identifierByFirstChar = new IdentifierByFirstChar();
        assertFalse(identifierByFirstChar.isGetMoneyAction("' RUR 100"));
    }

    @Test
    public void isPutMoneyActionPositive() {
        IdentifierByFirstChar identifierByFirstChar = new IdentifierByFirstChar();
        assertTrue(identifierByFirstChar.isPutMoneyAction("+ RUR 10 10"));
    }

    @Test
    public void isPutMoneyActionStartFromNumber() {
        IdentifierByFirstChar identifierByFirstChar = new IdentifierByFirstChar();
        assertFalse(identifierByFirstChar.isPutMoneyAction("1 RUR 10 10"));
    }

    @Test
    public void isPutMoneyActionStartFromApostrophe() {
        IdentifierByFirstChar identifierByFirstChar = new IdentifierByFirstChar();
        assertFalse(identifierByFirstChar.isPutMoneyAction("' RUR 10 10"));
    }

    @Test
    public void isShowBalanceActionPositive() {
        IdentifierByFirstChar identifierByFirstChar = new IdentifierByFirstChar();
        assertTrue(identifierByFirstChar.isShowBalanceAction("?"));
    }

    @Test
    public void isShowBalanceStartFromNumber() {
        IdentifierByFirstChar identifierByFirstChar = new IdentifierByFirstChar();
        assertFalse(identifierByFirstChar.isShowBalanceAction("1?"));
    }

    @Test
    public void isShowBalanceStartFromApostrophe() {
        IdentifierByFirstChar identifierByFirstChar = new IdentifierByFirstChar();
        assertFalse(identifierByFirstChar.isShowBalanceAction("'?"));
    }
}
