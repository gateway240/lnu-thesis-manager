package se.lnu.dao;

import java.io.IOException;
import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


@Component
public class RecordActivityDAOImpl implements RecordActivityDAO {
    private final static Logger logger = LoggerFactory.getLogger(RecordActivityDAOImpl.class);

    @Value("classpath:thesis-manager.db")
    Resource dbFile;

    public Connection connect() {
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

    public  void save(TAppActivityLog tAppActivityLog) {
        String sql = "INSERT INTO app_activity_log (username, user_ip, date_accessed,photos_sent) "
                + "values (?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,tAppActivityLog.getUsername());
            pstmt.setString(2,tAppActivityLog.getUserIp());
            pstmt.setString(3,  tAppActivityLog.getDateAccessed().toString());
            pstmt.setString(4,tAppActivityLog.getPhotosSent());
            pstmt.executeUpdate();
            logger.info("Activity recorded");
        } catch (SQLException e) {
            logger.error("Could not update activity record");
            logger.error(e.getMessage());
        }
    }


}
