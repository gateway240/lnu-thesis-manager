package se.lnu.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.lnu.entity.Grade;
import se.lnu.entity.User;
import se.lnu.repository.GradeRepository;

import java.util.List;
import java.util.Collection;
import javax.transaction.Transactional;

@Service
public class GradeDaoImpl implements GradeDao {
    @Autowired
    @Qualifier("gradeRepository")
    private GradeRepository gradeRepository;

    @Override
    @Transactional
    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    @Transactional
    public List<Grade> findAllGrades() {
        return gradeRepository.findAll();
    }

    public Collection<Grade> findGradesByUser(User user) {
        return gradeRepository.findGradesByUser(user);
    }
}
