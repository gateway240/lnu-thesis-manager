package se.lnu.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import se.lnu.dao.DeadlineDao;
import se.lnu.dao.SubmissionDao;
import se.lnu.dao.UserDao;
import se.lnu.entity.Document;
import se.lnu.entity.Submission;
import se.lnu.entity.User;
import se.lnu.email.EmailService;
import se.lnu.email.GmailSender;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/submission")
public class SubmissionController {
    final static Logger LOG = LoggerFactory.getLogger(SubmissionController.class);
    // ModelAndView is an object that holds both the model and view.
    // The handler returns the ModelAndView object and DispatcherServlet resolves
    // the view using View Resolvers and View.
    // Makes it possible for the controller to return both model and view in a single return value

    @Autowired
    private se.lnu.dao.DocumentDao documentDao;

    @Autowired
    private DeadlineDao deadlineDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SubmissionDao submissionDao;

    @RequestMapping("/uploadForm")
    public ModelAndView uploadForm() {
        return new ModelAndView("upload-form");
    }

    @RequestMapping(value = "/submitDocument", method = RequestMethod.GET)
    public String loadSubmitDocument(ModelMap map) {
        User authenticatedUser = userDao.getCurrentAuthenticatedUser();

        Submission submission = new Submission();

        map.addAttribute("submission",submission);
        map.addAttribute("deadlines", deadlineDao.findAllDeadlines());
        map.addAttribute("documents", documentDao.getDocumentsByUsername(authenticatedUser));

        return "submission/submitDocument";
    }

    @RequestMapping(value = "/addSubmission/submit", method = RequestMethod.POST)
    public String addSubmission(@Valid @ModelAttribute("submission") Submission submission){
        submission.setDate(new Date());
        User authenticatedUser = userDao.getCurrentAuthenticatedUser();
        submission.setUser(authenticatedUser);
        submissionDao.saveSubmission(submission);

        return "home/home";
    }
    // CommonsMultipartFile implementation for Apache Commons FileUpload.
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam CommonsMultipartFile file,
                               @RequestParam String title,
                               @RequestParam String category,
                               HttpSession session,
                               ModelMap model) {

        if (!(file.getOriginalFilename().endsWith(".pdf"))) {
            model.addAttribute("errorMessage", "Only PDF-files are allowed");
            return new ModelAndView("upload-form");
        }
        if(title.isEmpty()) {
            model.addAttribute("errorMessage", "Please enter a title for the document");
            return new ModelAndView("upload-form");
        }

        // get applications root
        String path = session.getServletContext().getRealPath("/WEB-INF/downloads/pdf");
        //String filename = file.getOriginalFilename();

        // Makes the file path unique
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        String downloadURL = "";
        LOG.info(path + " " + filename);

        try {

            byte barr[] = file.getBytes();

            // Retrieves file data and stores it in a buffer
            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(path + "/" + filename));

            bout.write(barr);
            bout.flush();
            bout.close();

            User authenticatedUser = userDao.getCurrentAuthenticatedUser();
            // Saves the document to the database
            Document document = new Document();
            document.setFilePath(path + "/" + filename);
            document.setTitle(title);
            document.setCategory(category);
            document.setFileName(filename);
            // set athor to the logged in users id
            if (authenticatedUser != null) {
                document.setAuthor(authenticatedUser);
            }
            downloadURL = "http://localhost:8080/lnu-thesis-manager/download/pdf/" + filename;
            document.setDownloadURL(downloadURL);

            model.addAttribute("title", title);

            documentDao.saveDocument(document);

            String gmailUsername = System.getenv("GMAIL_USERNAME");
            String gmailPassword = System.getenv("GMAIL_PASSWORD");
            String email = authenticatedUser.getEmail();
            if (gmailUsername != null && gmailPassword != null && email != null) {
                GmailSender gmailSender = new GmailSender(gmailUsername, gmailPassword);
                EmailService emailService = new EmailService(gmailSender.getJavaMailSender());
                emailService.sendEmail(email, "Uploaded document", "You have uploaded " +
                                       filename + " to the thesis management system.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return new ModelAndView("upload-success", "downloadURL", downloadURL);

    }
}
