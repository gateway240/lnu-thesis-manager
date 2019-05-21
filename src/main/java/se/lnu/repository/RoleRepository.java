package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lnu.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
}
