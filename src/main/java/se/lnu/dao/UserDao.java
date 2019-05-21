package se.lnu.dao;

import se.lnu.entity.Document;
import se.lnu.entity.Role;
import se.lnu.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User saveUser(User user);

    Document saveDocument(Document document);

    Role saveRole(Role role);
}
