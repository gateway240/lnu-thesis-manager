package se.lnu.service;
//based on tutorial on https://www.jackrutorial.com/2018/01/creating-a-web-application-with-spring-4-mvc-example-for-user-signup-login-and-logout-with-password-encoder-using-eclipse-mysql-database.html

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.lnu.dao.UserDao;
import se.lnu.entity.User;

@Service
public class UserServiceImpl implements UserService {
	UserDao userDao;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	 @Autowired
	 public void setUserDao(UserDao userDao) {
		 this.userDao = userDao;
	 }

	 public List<?> list() {
		 return userDao.list();
	 }

	 public User findUserByUsername(String username) {
		 return userDao.findUserByUsername(username);
	 }

	 public void update(String firstname, String lastname, String username, String email, String password) {
		 userDao.update(firstname, lastname, username, email, passwordEncoder.encode(password));
	 }

	 public void add(String firstname, String lastname, String username, String email, String password, String role) {
		 userDao.add(firstname, lastname, username, email, passwordEncoder.encode(password), role);
	 }

	 public boolean userExists(String username) {
		 return userDao.userExists(username);
	 }

	@Override
	public void delete(String username) {
		userDao.delete(username);
	}
}
