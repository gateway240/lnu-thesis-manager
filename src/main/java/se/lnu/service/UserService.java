package se.lnu.service;
import java.util.List;
import se.lnu.entity.User;

public interface UserService {
	 public List<?> list();
	 public User findUserByUsername(String username);
	 public void update(String firstname, String lastname, String username, String email, String password);
	 public void add(String firstname, String lastname, String username, String email, String password, String role);
	 public boolean userExists(String username);
	 public void delete(String username);
}
