package se.lnu.dao;

import se.lnu.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void saveUser(User user);
}
