package se.lnu.controllers;
//based on tutorial on https://www.jackrutorial.com/2018/01/creating-a-web-application-with-spring-4-mvc-example-for-user-signup-login-and-logout-with-password-encoder-using-eclipse-mysql-database.html

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import se.lnu.dao.GradeDao;
import se.lnu.dao.DocumentDao;
import se.lnu.dao.SubmissionDao;
import se.lnu.dao.UserDao;
import se.lnu.entity.User;
import se.lnu.entity.Grade;
import se.lnu.entity.Document;
import se.lnu.entity.Submission;
import se.lnu.form.UserForm;

import se.lnu.service.UserService;
import se.lnu.validator.SignupValidator;

import java.util.List;
import java.security.Principal;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    final static Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    SignupValidator signupValidator;

    @Autowired
    UserService userService;

    @Autowired
    SubmissionDao submissionDao;

    @Autowired
    DocumentDao documentDao;

    @Autowired
    GradeDao gradeDao;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list( ModelMap model) {
        List<User> users = userDao.getUsersByRole("ROLE_USER");
        model.addAttribute("list", users);
        return "user/list";
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(@RequestParam(value = "role", required = false) String role, ModelMap model) {
        List<User> users = userDao.getUsersByRole(role);
        model.addAttribute("users", users);
        return "user/users";
    }

    @RequestMapping(value="/viewDocument/{id}", method=RequestMethod.GET)
    public ModelAndView viewDocument(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("user/view_document");
        Optional<Document> document = documentDao.getDocumentById(id);
        if (document.isPresent()) {
            String filePath = document.get().getFilePath();
            model.addObject("document", document.get());
            model.addObject("file_name", filePath.substring(filePath.lastIndexOf("/") + 1));
        }
        return model;
    };

    @RequestMapping(value="/grades/{username}", method=RequestMethod.GET)
    public ModelAndView grade(@PathVariable("username") String username) {
        ModelAndView model = new ModelAndView("user/grades");
        User user = userDao.findUserByUsername(username);
        Collection<Grade> grades = gradeDao.findGradesByUser(user);
        model.addObject("grades", grades);
        return model;
    }

    @RequestMapping(value="/submissions", method=RequestMethod.GET)
    public ModelAndView submissions(@ModelAttribute("degree") String degree,
                                    @ModelAttribute("category") String category,
                                    @ModelAttribute("title") String title) {
        List<Submission> submissions = submissionDao.getAllSubmissions()
            .stream()
            .filter(s -> s.getDegree().toLowerCase().contains(degree) &&
                    Optional.ofNullable(s.getDocument().getCategory())
                    .orElse("").toLowerCase().contains(category) &&
                    s.getTitle().toLowerCase().contains(title.toLowerCase()))
            .collect(Collectors.toList());
        ModelAndView model = new ModelAndView("user/submissions");
        model.addObject("submissions", submissions);
        return model;
    }

	 @RequestMapping(value="/setAccount/{username}", method=RequestMethod.GET)
	 public ModelAndView setAccount(Principal principal, @PathVariable("username") String username){
		  ModelAndView model = new ModelAndView("user/account");
		  model.addObject("user", userService.findUserByUsername(username));
		  if (principal.getName().equals(username)) {
			  return model;
		  } else {
			  return new ModelAndView("errors/access_denied");
		  }
		  
	 }

	 @RequestMapping(value="/saveAccount", method=RequestMethod.POST)
	 public ModelAndView saveAccount(@ModelAttribute("user") User user){
		  ModelAndView model = new ModelAndView("user/account");
		  model.addObject("user", userService.findUserByUsername(user.getUsername()));
		  userService.update(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getPassword());
		  model.addObject("user", userService.findUserByUsername(user.getUsername()));
		  model.addObject("msg", "The account has been updated successfully!");
		  return model;
	 }

	 @RequestMapping(value="/deleteAccount", method=RequestMethod.POST)
	 public String deleteAccount(@ModelAttribute("user") User user){
		  ModelAndView model = new ModelAndView("user/account");
		  model.addObject("user", userService.findUserByUsername(user.getUsername()));
		  userService.delete(user.getUsername());
		  return "/";
	 }

    @RequestMapping(value = "/setGrade/{username}", method = RequestMethod.GET)
    public ModelAndView setGrade(@PathVariable("username") String username) {
        ModelAndView model = new ModelAndView("grade/set_grade");
        model.addObject("user", userService.findUserByUsername(username));
        return model;
    }

    @RequestMapping(value = "/changePass/{username}", method = RequestMethod.GET)
    public ModelAndView changePass(@PathVariable("username") String username) {
        ModelAndView model = new ModelAndView("user/change_pass");
        model.addObject("user", userService.findUserByUsername(username));
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") User user) {
        ModelAndView model = setGrade(user.getUsername());
        userService.update(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getPassword());
        model.addObject("msg", "The grade has been set successfully!");
        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView("user/signup");
        model.addObject("userForm", new UserForm());
        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("userForm") UserForm userForm,
                           BindingResult result, RedirectAttributes redirectAttributes) {

        signupValidator.validate(userForm, result);
        if (result.hasErrors()) {
            return "/user/signup";
        } else {
            userService.add(userForm.getFirstname(), userForm.getLastname(), userForm.getUsername(), userForm.getEmail(), userForm.getPassword(), userForm.getRole());
            redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully");
            return "redirect:/login";
        }
    }
}
