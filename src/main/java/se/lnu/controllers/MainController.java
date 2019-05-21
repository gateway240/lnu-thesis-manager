package se.lnu.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.lnu.dao.UserDao;
import se.lnu.entity.Document;
import se.lnu.entity.Role;
import se.lnu.entity.User;

@RequestMapping("")
@Controller
public class MainController {
    final static Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        Role role = new Role();
        role.setDescription("admin");
        role = userDao.saveRole(role);

        Document document = new Document();
        document.setFilePath("/u01/test");
        document.setTitle("TestDoc");

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setRole(role);
        user.addDocument(document);

        userDao.saveUser(user);


        model.addAttribute("message", "Lnu Thesis Manager!");
        return "hello";
    }
}
