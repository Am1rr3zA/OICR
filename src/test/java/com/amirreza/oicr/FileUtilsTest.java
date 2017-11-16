package com.amirreza.oicr;

import com.amirreza.exception.PowerSetFileException;
import com.amirreza.oicr.util.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Amirreza Soudi
 * @since 2017-11-15.
 */
public class FileUtilsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void readFileAndReturnSet() throws PowerSetFileException {
        URL url = this.getClass().getResource("/input-file-test.txt");
        Set<String> inputFromFile = FileUtils.readFile(url.getFile());

        Set<String> expectedSet = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5"));

        assertEquals(expectedSet, inputFromFile);
    }

    @Test
    public void readFileWithRedundantValue() throws PowerSetFileException {
        URL url = this.getClass().getResource("/input-redundant-test.txt");
        Set<String> inputFromFile = FileUtils.readFile(url.getFile());

        assertEquals(5, inputFromFile.size());
    }

    @Test(expected = PowerSetFileException.class)
    public void testFileNotExistThrowException() throws PowerSetFileException {
        FileUtils.readFile("SomeRandomFile.txt");
    }
}