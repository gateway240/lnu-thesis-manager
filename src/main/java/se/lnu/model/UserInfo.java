package se.lnu.model;
//based on tutorial on https://www.jackrutorial.com/2018/01/creating-a-web-application-with-spring-4-mvc-example-for-user-signup-login-and-logout-with-password-encoder-using-eclipse-mysql-database.html

public class UserInfo {
	 private String username;
	 private String password;
	 
	 public UserInfo() {
		 super();
	 }
	 
	 public UserInfo(String username, String password) {
		  super();
		  this.username = username;
		  this.password = password;
	 }
	 
	 public String getUsername() {
		 return username;
	 }
	 public void setUsername(String username) {
		 this.username = username;
	 }
	 public String getPassword() {
		 return password;
	 }
	 public void setPassword(String password) {
		 this.password = password;
	 }
	}