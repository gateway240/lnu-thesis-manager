package se.lnu.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection connect() {
        Resource dbFile = new ClassPathResource("thesis-manager.db");

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            logger.error("Class not found");
            logger.error(e.getMessage());
        }
        String dbURI = null;
        try {
            dbURI = dbFile.getURI().toString();
            logger.info("dbFile" + dbURI);
        } catch (IOException e) {
            logger.error("Could not find dbFile");
            logger.error(e.getMessage());
        }
        Connection conn = null;
        if(dbFile.exists()){
            String url = "jdbc:sqlite:"+dbURI;
            try {
                conn = DriverManager.getConnection(url);
                logger.info("Connected to database");
            } catch (SQLException e) {
                logger.info("Could not connect to database");
                logger.error(e.getMessage());
            }
        }

        return conn;
    }
}