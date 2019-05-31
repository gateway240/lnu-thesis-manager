package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lnu.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u WHERE u.username = :username")
    User findUserByUsername(@Param("username") String username);

}
