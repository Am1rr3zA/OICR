package com.amirreza.oicr;

import com.amirreza.oicr.exception.PowerSetFileException;
import com.amirreza.oicr.util.FileUtils;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Amirreza Soudi
 * @since 2017-11-15.
 */
public class FindPowerSet {
    final static Logger LOGGER = Logger.getLogger(FindPowerSet.class);

    public void findPowesetAndWrite(String inputFile, String outputFile) {
        Set<String> inputSet = new HashSet<>();
        try {
            inputSet = FileUtils.readFile(inputFile);
        } catch (PowerSetFileException e) {
            LOGGER.error("input file path does not exist", e);
        }

        Set<Set<String>> powerSet = PowerSet.computePowerSet(inputSet);

        FileUtils.writeToFile(outputFile, powerSet);
    }
}
