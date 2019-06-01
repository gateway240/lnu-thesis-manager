package se.lnu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.lnu.entity.Deadline;
import se.lnu.repository.DeadlineRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeadlineDaoImpl implements DeadlineDao {

    @Autowired
    @Qualifier("deadlineRepository")
    private DeadlineRepository deadlineRepository;

    @Override
    @Transactional
    public Deadline saveDeadline(Deadline deadline) {
        return deadlineRepository.save(deadline);
    }

    @Override
    @Transactional
    public List<Deadline> findAllDeadlines() {
        return deadlineRepository.findAll();
    }

    @Override
    @Transactional
    public List<Deadline> saveAllDeadlines(List<Deadline> deadlines) {
        return deadlineRepository.saveAll(deadlines);
    }
}
