/*package se.lnu.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//according to tutorial on https://www.journaldev.com/8718/spring-4-security-mvc-login-logout-example

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("student1").password("1234").authorities("ROLE_USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home").access("hasRole('ROLE_USER')").and()
		.formLogin().loginPage("/login")
			.defaultSuccessUrl("/home")
			.failureUrl("/login?error")
			.usernameParameter("username").passwordParameter("password").and()
			.logout().logoutSuccessUrl("/login?logout"); 
	}
}
 */
