package com.atm.actions.unit;

import com.atm.actionIdentificators.IIdentifier;
import com.atm.actionIdentificators.IdentifierByFirstChar;
import com.atm.actions.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ivoloshyn on 7/19/2016.
 */
public class ActionFactoryTest {

    @Test
    public void verifyPutMoneyAction() {
        ActionFactory actionFactory = new ActionFactory(new IdentifierByFirstChar());
        BaseAction action = actionFactory.getAction("+");
        assertTrue(action instanceof PutMoneyAction);
    }

    @Test
    public void verifyGetMoneyAction() {
        ActionFactory actionFactory = new ActionFactory(new IdentifierByFirstChar());
        BaseAction action = actionFactory.getAction("-");
        assertTrue(action instanceof GetMoneyAction);
    }

    @Test
    public void verifyShowBalanceAction() {
        ActionFactory actionFactory = new ActionFactory(new IdentifierByFirstChar());
        BaseAction action = actionFactory.getAction("?");
        assertTrue(action instanceof ShowBalanceAction);
    }
}