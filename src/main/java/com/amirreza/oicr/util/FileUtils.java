package com.amirreza.oicr.util;

import com.amirreza.exception.PowerSetFileException;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * @author Amirreza Soudi
 * @since 2017-11-15.
 */
public class FileUtils {
    final static Logger LOGGER = Logger.getLogger(FileUtils.class);

    public static Set<String> readFile(String path) throws PowerSetFileException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            Set<String> output = new HashSet<>();
            stream.forEach(output::add);

            return output;

        } catch (IOException e) {
            throw new PowerSetFileException("There is something wrong with input file");
        }
    }

    public static void writeToFile(String outputfile, Set<Set<String>> powerSet) {
        Path path = Paths.get(outputfile);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Set<String> set : powerSet) {

                StringJoiner joiner = new StringJoiner(",");

                for (String str : set) {
                    joiner.add(str);
                }
                writer.write("{");
                writer.write(joiner.toString());
                writer.write("}\n");
            }

        } catch (IOException e) {
            LOGGER.error("Can not write to the file: " + outputfile, e);
        }
    }
}
