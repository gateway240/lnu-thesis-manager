package se.lnu.dao;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import se.lnu.entities.TAppActivityLog;


@Component
public class RecordActivityDAOImpl implements RecordActivityDAO {
    private final static Logger logger = LoggerFactory.getLogger(RecordActivityDAOImpl.class);

    public  void save(TAppActivityLog tAppActivityLog) {
        String sql = "INSERT INTO app_activity_log (username, user_ip, date_accessed,photos_sent) "
                + "values (?,?,?,?)";

        try (Connection conn = ConnectionFactory.connect();
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
