package com.amirreza.oicr;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Amirreza Soudi
 * @since 2017-11-15.
 */
public class PowerSet {
    private static final Logger LOGGER = Logger.getLogger(PowerSet.class);

    /**
     * The total number of subset is equal to 2^(size of input set), we can compute the size and use its binary
     * representation to select all subset, whenever in binary represnation we have 1 it means we should select
     * that index number t our subset
     * input = {a, b} -> size 2^2 = 4  -> 00, 01, 10, 11
     * it means we should have {}, {b}, {a}, {ab}
     *
     *
     * @param input set of values
     * @return set of all subset
     */
    public static Set<Set<String>> computePowerSet(Set<String> input) {

        List<String> inputList = new ArrayList<>();
        inputList.addAll(input);
        Set<Set<String>> output = new HashSet<>();

        double powerSetSize = Math.pow(2, input.size());

        for (int i = 0; i < powerSetSize; i++) {
            Set<String> tmp = new HashSet<>();
            for (int j = 0; j < input.size(); j++) {
                if ((i & (1 << j)) > 0) {
                    tmp.add(inputList.get(j));
                }
            }
            output.add(tmp);
        }

        return output;
    }
}
