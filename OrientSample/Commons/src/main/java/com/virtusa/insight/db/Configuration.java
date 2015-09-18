package com.virtusa.insight.db;

import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author Lasitha Nuwan.
 */
public class Configuration {

    private String dataBase;
    private String userName;
    private String password;
    private static final String CONFIG_FILE = "config/config.properties";

    public Configuration() throws FileNotFoundException {

        Properties properties = Commons.loadProperties(CONFIG_FILE);
        this.dataBase = properties.getProperty("dataBase");
        this.password = properties.getProperty("password");
        this.userName = properties.getProperty("userName");
    }

    /**
     * @return dataBase name.
     */
    public String getDataBase() {
        return dataBase;
    }

    /**
     * @return dataBase password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return user name fro dataBase
     */
    public String getUserName() {
        return userName;
    }

}
