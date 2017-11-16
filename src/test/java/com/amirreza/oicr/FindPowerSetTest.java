package com.amirreza.oicr;

import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * @author Amirreza Soudi
 * @since 2017-11-15.
 */
public class FindPowerSetTest {

    @Test
    public void integrationTest() {
        String outputFile = "output-file-test.txt";
        FindPowerSet fps = new FindPowerSet();
        URL inputUrl = this.getClass().getResource("/input-file-test.txt");
        fps.findPowesetAndWrite(inputUrl.getFile(), outputFile);
        File file = new File(outputFile);
        assertTrue(file.exists());
    }

}