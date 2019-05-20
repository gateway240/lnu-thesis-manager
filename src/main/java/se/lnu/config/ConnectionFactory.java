package se.lnu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Connect to Database
 */
class ConnectionFactory {

    private final static Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);
    private final static String DEFAULT_URL = "jdbc:sqlite:/u01/thesis-manager.db";

    static String getURL() {
        Resource dbFile = new ClassPathResource("thesis-manager.db");
        String dbURI = null;
        try {
            dbURI = dbFile.getURI().toString();
            logger.info("dbFile" + dbURI);
        } catch (IOException e) {
            logger.error("Could not find dbFile");
            logger.error(e.getMessage());
        }
        String url = DEFAULT_URL;
        if (dbFile.exists()) {
            url = "jdbc:sqlite:" + dbURI;
        }
        return url;
    }

}