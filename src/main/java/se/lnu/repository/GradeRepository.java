package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;

import se.lnu.entity.Grade;
import se.lnu.entity.User;

@Repository("gradeRepository")
public interface GradeRepository extends JpaRepository<Grade, Integer> {
	@Query("select g from Grade g WHERE g.user = :user")
    Collection<Grade> findGradesByUser(@Param("user") User user);
}
