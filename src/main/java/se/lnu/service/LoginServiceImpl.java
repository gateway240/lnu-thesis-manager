package se.lnu.service;
//based on tutorial on https://www.jackrutorial.com/2018/01/creating-a-web-application-with-spring-4-mvc-example-for-user-signup-login-and-logout-with-password-encoder-using-eclipse-mysql-database.html

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.lnu.dao.LoginDao;

@Service
public class LoginServiceImpl implements UserDetailsService {
	LoginDao loginDao;
	
	 @Autowired
	 public void setLoginDao(LoginDao loginDao) {
		 this.loginDao = loginDao;
	 }

	 @SuppressWarnings("unchecked")
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 se.lnu.entity.User user = loginDao.findUser(username);
	  
	  if(user == null){
		  throw new UsernameNotFoundException("username was not found in the database");
	  }
	  
	  List<?> roles = loginDao.getUserRoles(username);
	  
	  @SuppressWarnings("rawtypes")
	  List grantList = new ArrayList();
	  
	  if(roles != null){
		   for(Object role : roles){
			   GrantedAuthority authority = new SimpleGrantedAuthority((String) role);
			   grantList.add(authority);
	   }
	  }
	  
	  UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantList);
	  
	  return userDetails;
	 }
}
