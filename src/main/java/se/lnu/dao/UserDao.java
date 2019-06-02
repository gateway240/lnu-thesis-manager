package se.lnu.dao;

//import se.lnu.entity.Role;
//import se.lnu.entity.User;
import se.lnu.entity.User;
import se.lnu.entity.UserCoordinator;
import se.lnu.entity.UserSupervisor;

import java.util.List;

public interface UserDao {

	User getUserByUsername(String username);
	User getCurrentAuthenticatedUser();
    List<User> getUsers();
    List<User> getUsersByRole(String Role);
    UserSupervisor saveUserSupervisor(UserSupervisor userSupervisor);
    UserCoordinator saveUserCoordinator(UserCoordinator userCoordinator);
//    User saveUser(User user);
//    Role saveRole(Role role);
	 public List<?> list();
	 public User findUserByUsername(String username);
	 public void update(String firstname, String lastname, String username, String email, String password);
	 public void add(String firstname, String lastname, String username, String email, String password, String role);
	 public boolean userExists(String username);
	 void delete(String username);
}
