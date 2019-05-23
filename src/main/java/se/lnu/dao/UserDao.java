package se.lnu.dao;

import se.lnu.entity.Role;
import se.lnu.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User saveUser(User user);

    Role saveRole(Role role);
}
