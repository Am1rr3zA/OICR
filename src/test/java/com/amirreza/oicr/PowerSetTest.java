package com.amirreza.oicr;

import org.junit.Test;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Amirreza Soudi
 * @since 2017-11-15.
 */
public class PowerSetTest {

    @Test
    public void computePowerSet() {
        Set<String> inputSet = new HashSet<>(Arrays.asList("1", "2"));

        Set<Set<String>> powerSetResult = PowerSet.computePowerSet(inputSet);

        Set<Set<String>> expectedPowerSetResult = new HashSet<>();
        expectedPowerSetResult.add(new HashSet<>(Collections.emptyList()));
        expectedPowerSetResult.add(new HashSet<>(Collections.singletonList("2")));
        expectedPowerSetResult.add(new HashSet<>(Collections.singletonList("1")));
        expectedPowerSetResult.add(new HashSet<>(Arrays.asList("1", "2")));

        assertEquals(expectedPowerSetResult, powerSetResult);
    }

    @Test
    public void computeLargePowerSet() {
        Set<String> inputSet = new HashSet<>();
        for (int i = 0; i < 20 ; i++) {
            inputSet.add(String.valueOf((int) (Math.random() * 10000)));
        }

        Set<Set<String>> powerSetResult = PowerSet.computePowerSet(inputSet);

        assertEquals((long) Math.pow(2, inputSet.size()), powerSetResult.size());
    }


    @Test
    public void computePowerSetOfEmptySet() {
        Set<String> inputSet = new HashSet<>(Collections.emptyList());

        Set<Set<String>> powerSetResult = PowerSet.computePowerSet(inputSet);

        Set<Set<String>> expectedPowerSetResult = new HashSet<>();
        expectedPowerSetResult.add(new HashSet<>(Collections.emptyList()));

        assertEquals(expectedPowerSetResult, powerSetResult);
    }
}