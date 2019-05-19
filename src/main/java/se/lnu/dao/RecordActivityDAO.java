package se.lnu.dao;

import java.sql.Connection;

public interface RecordActivityDAO {
    Connection connect();

    void save(TAppActivityLog tAppActivityLog);

}
