package se.lnu.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.lnu.dao.DocumentDao;
import se.lnu.dao.UserDao;
import se.lnu.entity.*;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/test")
@Controller
public class MainController {
    final static Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
   private UserDao userDao;
    @Autowired
    private DocumentDao documentDao;

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
//        Role role = new Role();
//        role.setDescription("admin");
//        role = userDao.saveRole(role);
//
//        Document document = new Document();
//        document.setFilePath("/u01/test");
//        document.setTitle("TestDoc");
//        documentDao.saveDocument(document);
//
        UserSupervisor  userSupervisor = new UserSupervisor();
        UserCoordinator userCoordinator = new UserCoordinator();
        User student = userDao.getUserByUsername("student");
        User supervisor = userDao.getUserByUsername("supervisor");
        User coordinator = userDao.getUserByUsername("coordinator");

        userSupervisor.setStatus("approved");
        userSupervisor.setUser(student);
        userSupervisor.setSupervisor(supervisor);

        userCoordinator.setStatus("pending");
        userCoordinator.setUser(student);
        userCoordinator.setCoordinator(coordinator);

        userDao.saveUserSupervisor(userSupervisor);
        userDao.saveUserCoordinator(userCoordinator);


//        user.setRole(role);
//        user.addDocument(document);
//
//        userDao.saveUser(user);


        model.addAttribute("message", "Lnu Thesis Manager!");
        return "home/home";
    }
}
