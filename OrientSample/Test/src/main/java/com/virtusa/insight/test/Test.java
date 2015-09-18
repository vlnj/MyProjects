package com.virtusa.insight.test;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.virtusa.insight.db.DbUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Lasitha Nuwan
 */
public class Test {

    final static Logger LOGGER = Logger.getLogger(Test.class);

    public static void main(String[] args) throws FileNotFoundException {

        PropertyConfigurator.configure("config/log4j.properties");


        ODatabaseDocumentTx db = DbUtils.dbConnection();
        List<ODocument> documentList = db.query(new OSQLSynchQuery<ODocument>("SELECT FROM Student LIMIT 1"));
        ODocument oDocument = documentList.get(0);
        String name = oDocument.field("name");
        String company = oDocument.field("company");
        LOGGER.info("Student Name :" + name);
        LOGGER.info("Student Company :" + company);

        DbUtils.shutDownDb();
    }
}
