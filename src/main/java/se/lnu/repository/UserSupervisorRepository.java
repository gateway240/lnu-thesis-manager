package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lnu.entity.UserSupervisor;

@Repository("userSupervisorRepository")
public interface UserSupervisorRepository extends JpaRepository<UserSupervisor, Integer> {
}
