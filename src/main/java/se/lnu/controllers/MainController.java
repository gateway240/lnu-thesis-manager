package se.lnu.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.lnu.dao.RecordActivityDAOImpl;
import se.lnu.dao.TAppActivityLog;

import java.util.Date;

@RequestMapping("")
@Controller
public class MainController {
    final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    RecordActivityDAOImpl recordActivityDao;

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model){

// we record this request in the database
        TAppActivityLog tAppActivityLog = new TAppActivityLog();
        tAppActivityLog.setDateAccessed(new Date());
        tAppActivityLog.setUsername("John");


        recordActivityDao.save(tAppActivityLog);

        model.addAttribute("message","Lnu Thesis Manager!");
        return "hello";
    }
}
