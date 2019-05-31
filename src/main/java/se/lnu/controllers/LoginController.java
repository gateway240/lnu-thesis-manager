package se.lnu.controllers;
//based on tutorial on https://www.jackrutorial.com/2018/01/creating-a-web-application-with-spring-4-mvc-example-for-user-signup-login-and-logout-with-password-encoder-using-eclipse-mysql-database.html

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class LoginController {
	
	 @RequestMapping(value="/login", method=RequestMethod.GET)
	 public ModelAndView login(@RequestParam(value="error", required = false) String error){
		  ModelAndView model = new ModelAndView();
		  
		  if(error != null){
			  model.addObject("msg", "Credentials are incorrect. Please try again.");
		  }
		  model.setViewName("login/login");
		  return model;
	 }
	 
	 @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
	 public ModelAndView home(){
		  ModelAndView model = new ModelAndView();
		  model.setViewName("home/home");
		  return model;
	 }
	 
	 @RequestMapping(value="/logout", method=RequestMethod.GET)
	 public String logoutPage(HttpServletRequest request, HttpServletResponse response){
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if(auth != null){
			  new SecurityContextLogoutHandler().logout(request, response, auth);
		  }
		  return "redirect:/login";
	 }
	 
	 @RequestMapping(value="/errors/access_denied", method=RequestMethod.GET)
	 public ModelAndView accessDenied(){
		  ModelAndView model = new ModelAndView();
		  model.setViewName("errors/access_denied");
		  return model;
	 }
}
