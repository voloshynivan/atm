package com.atm.logs;

/**
 * Created by ivoloshyn on 6/8/2016.
 */
public class SOUTLog implements ILog {

    @Override
    public void log(String message) {
        System.out.println(message);
    }

}
