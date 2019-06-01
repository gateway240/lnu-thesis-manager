package se.lnu.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.lnu.entity.Grade;
import se.lnu.repository.GradeRepository;

import javax.transaction.Transactional;
import java.util.List;

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
}

