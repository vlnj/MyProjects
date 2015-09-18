package com.virtusa.insight.db;

import com.orientechnologies.common.exception.OException;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import org.apache.log4j.Logger;
import java.io.FileNotFoundException;

/**
 * @author Lasitha Nuwan.
 */
public class DbUtils {
    /**
     * Logger.
     */
    final static Logger LOGGER = Logger.getLogger(DbUtils.class);
    private static ODatabaseDocumentTx db = null;

    /**
     * Private Constructor.
     */
    private DbUtils() {
    }

    /**
     * @return DataBase connection
     */
    public static ODatabaseDocumentTx dbConnection() throws FileNotFoundException {

        try {
            Configuration configuration = new Configuration();
            LOGGER.debug("Opening Database " + configuration.getDataBase() + "...");
            db = new ODatabaseDocumentTx("remote:localhost/" + configuration.getDataBase());
            db.open(configuration.getUserName(), configuration.getPassword());

            if (!db.isClosed()) {
                return db;
            }
        } catch (OException e) {
            LOGGER.error("Failed to connect to the Database :", e);
        }
        return db;
    }

    /**
     * Close DataBase Connection.
     */
    public static void shutDownDb() {

        LOGGER.debug("Shutting Down Database...");
        db.close();
        LOGGER.debug("Shut Down Database Completed");
    }
}
