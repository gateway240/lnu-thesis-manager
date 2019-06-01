package se.lnu.dao;
import java.util.List;
import se.lnu.entity.User;

public interface LoginDao {
	User findUser(String username);
	List<?> getUserRoles(String username);
}
