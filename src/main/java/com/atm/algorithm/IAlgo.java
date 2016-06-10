package com.atm.algorithm;

import com.atm.logs.ILog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivoloshyn on 6/10/2016.
 */
public interface IAlgo {
    void removeMoney(Map<String, HashMap<Integer, Integer>> currentBalance, String currency, int amount);
    boolean isAlgorithmPossible(Map<String, HashMap<Integer, Integer>> currentBalance, String currency, int amount);
}
