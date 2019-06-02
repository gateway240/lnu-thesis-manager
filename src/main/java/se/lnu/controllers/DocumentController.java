package se.lnu.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import se.lnu.dao.DocumentDao;
import se.lnu.dao.UserDao;
import se.lnu.entity.Document;
import se.lnu.entity.Feedback;
import se.lnu.entity.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/document")
@Controller
public class DocumentController {
    final static Logger LOG = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public Feedback saveFeedback(ModelMap modelMap){

        return null;
    }
    @RequestMapping(value="/getAllDocuments", method=RequestMethod.GET)
    public ModelAndView getAllDocuments() {

        List<Document> docs = new ArrayList<>();

        docs = documentDao.viewAllDocuments();

        ModelAndView modelAndView = new ModelAndView("document");
        modelAndView.addObject("docs", docs);

        return modelAndView;
    }
    @RequestMapping(value = "/addFeedback", method = RequestMethod.POST)
    public String addFeedback(@Valid @ModelAttribute("feedback") Feedback feedback){
        User authenticatedUser = userDao.getCurrentAuthenticatedUser();
        feedback.setReviewer(authenticatedUser);

        documentDao.saveFeedback(feedback);


        return "home/home";
    }




}
