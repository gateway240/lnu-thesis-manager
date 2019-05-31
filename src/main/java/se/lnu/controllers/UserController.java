package se.lnu.controllers;
//based on tutorial on https://www.jackrutorial.com/2018/01/creating-a-web-application-with-spring-4-mvc-example-for-user-signup-login-and-logout-with-password-encoder-using-eclipse-mysql-database.html

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import se.lnu.dao.UserDao;
import se.lnu.entity.User;
import se.lnu.form.UserForm;
import se.lnu.model.UserInfo;
import se.lnu.service.UserService;
import se.lnu.validator.SignupValidator;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    final static Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    SignupValidator signupValidator;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<User> users = userDao.getUsersByRole("ROLE_USER");
        model.addAttribute("list", users);
        return "user/list";
    }

    @RequestMapping(value = "/setGrade/{username}", method = RequestMethod.GET)
    public ModelAndView setGrade(@PathVariable("username") String username) {
        ModelAndView model = new ModelAndView("user/set_grade");
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
    public ModelAndView save(@ModelAttribute("user") UserInfo user) {
        ModelAndView model = setGrade(user.getUsername());
        userService.update(user.getUsername(), user.getPassword());
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
            userService.add(userForm.getUsername(), userForm.getPassword());
            redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully");
            return "redirect:/login";
        }
    }
}
