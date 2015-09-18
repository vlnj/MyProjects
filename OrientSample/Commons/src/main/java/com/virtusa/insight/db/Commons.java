package com.virtusa.insight.db;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Lasitha Nuwan on 9/15/2015.
 */
public class Commons {

    /**
     * Initialize Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Commons.class);

    /**
     * @param configFile property file to load.
     * @return properties.
     * @throws FileNotFoundException throws exception when file note found.
     */
    public static Properties loadProperties(String configFile) throws FileNotFoundException {

        FileInputStream fileInputStream = null;
        Properties properties = null;
        try {
            LOGGER.info("Loading configurations...");
            properties = new Properties();
            fileInputStream = new FileInputStream(configFile);
            properties.load(fileInputStream);
            PropertyConfigurator.configure(properties);

        } catch (IOException e) {
            throw new FileNotFoundException("Failed find the property file ");
        } finally {
            closeStream(fileInputStream);
        }
        return properties;
    }

    /**
     * @param fileInputStream close the stream.
     */
    private static void closeStream(FileInputStream fileInputStream) {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                LOGGER.error("Unable to close the stream ", e);
            }
        }
    }

}
