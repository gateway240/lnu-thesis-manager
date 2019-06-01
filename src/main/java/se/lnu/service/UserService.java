package se.lnu.service;
import java.util.List;
import se.lnu.model.UserInfo;

public interface UserService {
	 public List<?> list();
	 public UserInfo findUserByUsername(String username);
	 public void update(String username, String password);
	 public void add(String firstname, String lastname, String username, String email, String password, String role);
	 public boolean userExists(String username);
}
