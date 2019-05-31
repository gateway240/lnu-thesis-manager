package se.lnu.dao;

//import se.lnu.entity.Role;
//import se.lnu.entity.User;
import se.lnu.entity.User;
import se.lnu.model.UserInfo;
import java.util.List;

public interface UserDao {

	User getUserByUsername(String username);
//    List<User> getUsers();
//    User saveUser(User user);
//    Role saveRole(Role role);
	 public List<?> list();
	 public UserInfo findUserByUsername(String username);
	 public void update(String username, String password);
	 public void add(String username, String password);
	 public boolean userExists(String username);
}
