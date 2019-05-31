package se.lnu.dao;
import java.util.List;
import se.lnu.model.UserInfo;

public interface LoginDao {
	UserInfo findUserInfo(String username);
	List<?> getUserRoles(String username);
}
