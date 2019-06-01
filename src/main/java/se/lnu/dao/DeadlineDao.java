package se.lnu.dao;

import se.lnu.entity.Deadline;

import java.util.List;


public interface DeadlineDao {

    Deadline saveDeadline(Deadline deadline);

    List<Deadline> findAllDeadlines();

    List<Deadline> saveAllDeadlines(List<Deadline> deadlines);

}
