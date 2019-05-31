package se.lnu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.lnu.dao.DeadlineDao;
import se.lnu.entity.Deadline;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/deadline")
@Controller
public class DeadlineController {

    @Autowired
    DeadlineDao deadlineDao;

    @RequestMapping(method = RequestMethod.GET)
    public String loadPage( ModelMap model){
        model.addAttribute("deadlines",deadlineDao.findAllDeadlines());
        model.addAttribute( "deadline", new Deadline());
        return "deadline/deadline";
    }
    @RequestMapping(value = "/addDeadline", method = RequestMethod.POST)
    public String addDeadline(@Valid @ModelAttribute("deadline") Deadline deadline, ModelMap model){
        deadlineDao.saveDeadline(deadline);
        model.addAttribute("deadlines",deadlineDao.findAllDeadlines());
        return "deadline/deadline";
    }
    @RequestMapping(value= "/saveDeadlines", method = RequestMethod.POST)
    public String saveDeadlines(@Valid @ModelAttribute("deadlines") List<Deadline> deadlineList, ModelMap model){
        deadlineDao.saveAllDeadlines(deadlineList);
        model.addAttribute("deadlines",deadlineDao.findAllDeadlines());
        return "deadline/deadline";
    }
}
