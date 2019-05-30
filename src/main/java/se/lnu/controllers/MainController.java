package se.lnu.controllers;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.ui.Model;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import se.lnu.dao.UserDao;
//import se.lnu.model.User;

@Controller
public class MainController {
	//private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("start");
		return model;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser() {
		return "start";
	}

	//Coordinator's homepage
	@RequestMapping(value = "/coordinator**", method = RequestMethod.GET)
	public ModelAndView coordinatorPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("coordinator");
		return model;
	}
	
	//Student's homepage
	@RequestMapping(value = "/student**", method = RequestMethod.GET)
	public ModelAndView studentPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("student");

		return model;
	}
	
	//Supervisor's homepage
	@RequestMapping(value = "/supervisor**", method = RequestMethod.GET)
	public ModelAndView supervisorPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("supervisor");
		return model;
	}

	//Login and Logout
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid credentials. Please try again.");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	//Logout redirection
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {

		ModelAndView model = new ModelAndView();
		model.setViewName("start");

		return model;

	}
	
	//403 access denied page
	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is logged in
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("access_denied");
		return model;
		
	}
	
	/*	
	@Autowired
	private Demo service;
	
	public void setService(App app) {
		this.service = app;
	}
	
	@ModelAttribute("role")
	public List<Role> loadAllRoles() {
		return service.loadAllRoles();
	}
	
	@RequestMapping("/registration")
	public String loadForm(Model model, User field) {
		model.addAttribute("field", field);
		return "registration";
	}

	@RequestMapping("/process-form")
	public String processForm(Model model, User field) {
		model.addAttribute("field", field);
		service.addUser(field);
		return "success";
	}*/

/*	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute AutoUser user) {
		user.setRole("ROLE_USER");
		repo.save(user);
		return "login";
	}*/
	
	/*	@Autowired
	UserDao dao;

	@RequestMapping("/registration")
	public ModelAndView registration() {
		return new ModelAndView("registration", "command", new User());
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute(" ") User user) {
		dao.addUser(user);
		return new ModelAndView("redirect:/login");
	}*/
	
/*	@Autowired
	public UserService userService;
	  
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("registration");
		model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
		userService.register(user);
		return new ModelAndView("login");
	}*/
}
 