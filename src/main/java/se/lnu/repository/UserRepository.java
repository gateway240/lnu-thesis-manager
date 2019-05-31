package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lnu.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

}
