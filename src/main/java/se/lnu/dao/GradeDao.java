package se.lnu.dao;
import se.lnu.entity.Grade;
import java.util.List;

public interface GradeDao {
    Grade addGrade(Grade grade);
    List<Grade> findAllGrades();
}



