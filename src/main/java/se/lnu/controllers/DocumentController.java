package se.lnu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import se.lnu.dao.DocumentDao;
import se.lnu.entity.Document;
import se.lnu.entity.Feedback;


@RequestMapping("/document") 
@RestController
public class DocumentController {
    final static Logger LOG = LoggerFactory.getLogger(DocumentController.class);
    
    @Autowired
    private DocumentDao DocumentDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public Feedback saveFeedback(ModelMap modelMap){

        return null;
    }
   
    @RequestMapping(value="/getAllDocuments", method=RequestMethod.GET)
    public ModelAndView getAllDocuments() {
        	
       	List<Document> docs = new ArrayList<>();
       		
       	docs = DocumentDao.viewAllDocuments();
       	
    	ModelAndView modelAndView = new ModelAndView("document");
    	modelAndView.addObject("docs", docs);
       	
       	return modelAndView;
    }
        
}
