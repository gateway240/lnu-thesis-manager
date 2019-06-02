package se.lnu.dao;
import se.lnu.entity.Grade;
import se.lnu.entity.User;
import java.util.List;
import java.util.Collection;

public interface GradeDao {
    Grade addGrade(Grade grade);
    List<Grade> findAllGrades();
    public Collection<Grade> findGradesByUser(User user);
}
