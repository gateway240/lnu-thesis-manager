package se.lnu.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connect to Database
 */
public class ConnectionFactory {

    private final static Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

    @Autowired
    private static Environment env;

    public static String getURL() {
        Resource dbFile = new ClassPathResource("thesis-manager.db");
        String dbURI = null;
        try {
            dbURI = dbFile.getURI().toString();
            logger.info("dbFile" + dbURI);
        } catch (IOException e) {
            logger.error("Could not find dbFile");
            logger.error(e.getMessage());
        }
        String url = env.getProperty("jdbc.url");
        if (dbFile.exists()) {
            url = "jdbc:sqlite:" + dbURI;
        }
        return url;
    }

    /**
     * Get a connection to database
     *
     * @return Connection object
     */
    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            logger.error("Class not found");
            logger.error(e.getMessage());
        }

        String url = getURL();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            logger.info("Connected to database");
        } catch (SQLException e) {
            logger.info("Could not connect to database");
            logger.error(e.getMessage());
        }


        return conn;
    }
}