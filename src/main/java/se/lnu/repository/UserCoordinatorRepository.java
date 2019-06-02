package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lnu.entity.UserCoordinator;
import se.lnu.entity.UserSupervisor;

@Repository("userCoordinatorRepository")
public interface UserCoordinatorRepository extends JpaRepository<UserCoordinator, Integer> {
}
