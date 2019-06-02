package se.lnu.dao;
//based on tutorial on https://www.jackrutorial.com/2018/01/creating-a-web-application-with-spring-4-mvc-example-for-user-signup-login-and-logout-with-password-encoder-using-eclipse-mysql-database.html

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

//import org.springframework.stereotype.Service;
//import se.lnu.entity.Role;
//import se.lnu.entity.User;
//import se.lnu.repository.DocumentRepository;
//import se.lnu.repository.RoleRepository;
//import se.lnu.repository.UserRepository;
//
//import javax.transaction.Transactional;
import se.lnu.controllers.UserController;
import se.lnu.entity.User;
import se.lnu.entity.User;
import se.lnu.entity.UserCoordinator;
import se.lnu.entity.UserSupervisor;
import se.lnu.repository.UserCoordinatorRepository;
import se.lnu.repository.UserRepository;
import se.lnu.repository.UserSupervisorRepository;

import javax.transaction.Transactional;

@Repository
public class UserDaoImpl implements UserDao {
	final static Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);
    @Autowired
	@Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userSupervisorRepository")
    private UserSupervisorRepository userSupervisorRepository;

    @Autowired
    @Qualifier("userCoordinatorRepository")
    private UserCoordinatorRepository userCoordinatorRepository;

    @Override
    @Transactional
    public UserSupervisor saveUserSupervisor(UserSupervisor userSupervisor) {
        return userSupervisorRepository.save(userSupervisor);
    }

    @Override
    public UserCoordinator saveUserCoordinator(UserCoordinator userCoordinator) {
        return userCoordinatorRepository.save(userCoordinator);
    }

    @Override
	@Transactional
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

	//
//    @Autowired
//    private DocumentRepository documentRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
    @Override
    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll();
    }

	@Override
	@Transactional
	public List<User> getUsersByRole(String role) {
		if(role != null){
			List<User> allUsers = getUsers();
			List<User> filteredUsers = new ArrayList<>();
			allUsers.forEach( user -> {
				LOG.info("Role Desired: " + role);
				LOG.info("Role of Current User: " + user.getRoles().get(0).getRole());
				user.getRoles().forEach( localRole -> {
					if(localRole.getRole().equals(role)){
						filteredUsers.add(user);
						return;
					}
				});
			});
			return filteredUsers;
		}
		else{
			return getUsers();
		}

	}

	@Override
	public User getCurrentAuthenticatedUser() {
		//Get current user
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User authenticatedUser = new User();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			LOG.info("CurrentUserName: " + currentUserName);
			authenticatedUser = getUserByUsername(currentUserName);

		}
		return authenticatedUser;
	}
	//
//    @Override
//    @Transactional
//    public Role saveRole(Role role) {
//        return roleRepository.save(role);
//    }
//
//    @Override
//    @Transactional
//    public User saveUser(User user) {
//        documentRepository.saveAll(user.getDocuments());
//        return userRepository.save(user);
//    }
	
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		 this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }

	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public List list() {
		 String sql = "select username from users";
		 List list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null, null, null, null, null), new UserMapper());
	 return list;
	 }
	 
	 private SqlParameterSource getSqlParameterSource(String firstname, String lastname, String username, String email, String password, String role){
		 MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		 if(firstname != null){
			 parameterSource.addValue("firstname", firstname);
		 }
		  
		 if(lastname != null){
			 parameterSource.addValue("lastname", lastname);
		 }
		 
		 if(username != null){
			 parameterSource.addValue("username", username);
		 }
		  
		 if(email != null){
			 parameterSource.addValue("email", email);
		 }
		 
		 if(password != null){
			 parameterSource.addValue("password", password);
		 }
		 
		 if(role != null){
			 parameterSource.addValue("role", role);
		 }
		  
		 return parameterSource;
	 }
	 
	@SuppressWarnings("rawtypes")
	private static final class UserMapper implements RowMapper{
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		     User user = new User();
		     user.setFirstName(rs.getString("firstname"));
		     user.setLastName(rs.getString("lastname"));
		     user.setUsername(rs.getString("username"));
		     user.setEmail(rs.getString("email"));
		   
		     return user;
		}
	}
	
	public User findUserByUsername(String username) {
			String sql = "select * from users where username = :username";
				  
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null, username, null, null, null), new UserMapper());
		return (User) list.get(0);
	}

	public void update(String firstname, String lastname, String username, String email, String password) {
		String sql = "update users set firstname = :firstname, lastname = :lastname, email = :email, password = :password where username = :username";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(firstname, lastname, username, email, password, null));
	}

	public void add(String firstname, String lastname, String username, String email, String password, String role) {
		String sql = "insert into users(firstname,lastname,username,email,password) values(:firstname,:lastname,:username,:email,:password)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(firstname,lastname,username,email,password, role));
		sql = "insert into user_roles(username, role) values(:username, :role)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(firstname,lastname,username,email,password, role));
	}

	public boolean userExists(String username) {
		String sql = "select * from users where username = :username";
		@SuppressWarnings("unchecked")
		List<?> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null, username, null, null, null), new UserMapper());
		  
		if(list.size() > 0){
		   return true;
		}
		   return false;
		}

	@Override
	public void delete(String username) {
		String sql = "delete from users where username = :username";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(null, null, username, null, null, null));	
	}
}
