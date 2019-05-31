package se.lnu.dao;
//based on tutorial on https://www.jackrutorial.com/2018/01/creating-a-web-application-with-spring-4-mvc-example-for-user-signup-login-and-logout-with-password-encoder-using-eclipse-mysql-database.html

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

//import org.springframework.stereotype.Service;
//import se.lnu.entity.Role;
//import se.lnu.entity.User;
//import se.lnu.repository.DocumentRepository;
//import se.lnu.repository.RoleRepository;
//import se.lnu.repository.UserRepository;
//
//import javax.transaction.Transactional;
import se.lnu.entity.User;
import se.lnu.model.UserInfo;
import se.lnu.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
	@Qualifier("userRepository")
    private UserRepository userRepository;

	@Override
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
//    @Override
//    @Transactional
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
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
		 List list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null), new UserMapper());
	 return list;
	 }
	 
	 private SqlParameterSource getSqlParameterSource(String username, String password){
		 MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		 if(username != null){
			 parameterSource.addValue("username", username);
		 }
		  
		 if(password != null){
			 parameterSource.addValue("password", password);
		 }
		  
		 return parameterSource;
	 }
	 
	@SuppressWarnings("rawtypes")
	private static final class UserMapper implements RowMapper{
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		     UserInfo user = new UserInfo();
		     user.setUsername(rs.getString("username"));
		   
		     return user;
		}
	}
	
	public UserInfo findUserByUsername(String username) {
			String sql = "select username from users where username = :username";
				  
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username, null), new UserMapper());
		return (UserInfo) list.get(0);
	}

	public void update(String username, String password) {
		String sql = "update users set password = :password where username = :username";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
	}

	public void add(String username, String password) {
		String sql = "insert into users(username, password) values(:username, :password)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
		sql = "insert into user_roles(username, role) values(:username, 'ROLE_USER')";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
	}

	public boolean userExists(String username) {
		String sql = "select * from users where username = :username";
		@SuppressWarnings("unchecked")
		List<?> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username, null), new UserMapper());
		  
		if(list.size() > 0){
		   return true;
		}
		   return false;
		}
}
