package se.lnu.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import se.lnu.dao.DocumentDao;
import se.lnu.entity.Document;

@Controller
public class FileUploadController {
	
	// ModelAndView is an object that holds both the model and view. 
	// The handler returns the ModelAndView object and DispatcherServlet resolves 
	// the view using View Resolvers and View.
	// Makes it possible for the controller to return both model and view in a single return value
	
	@Autowired
    private DocumentDao DocumentDao;
	
	@RequestMapping("/uploadForm")
	public ModelAndView uploadForm() {
		return new ModelAndView("upload-form");
	}
	// CommonsMultipartFile implementation for Apache Commons FileUpload.
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public ModelAndView upload(@RequestParam CommonsMultipartFile file, HttpSession session, @RequestParam String title, ModelMap model) {
		
		if(!(file.getOriginalFilename().endsWith(".pdf"))) {
			model.addAttribute("errorMessage", "Only PDF-files are allowed");
			return new ModelAndView("upload-form");
		}

		// get applications root 
		String path = session.getServletContext().getRealPath("/WEB-INF/downloads/pdf");
		//String filename = file.getOriginalFilename();
		
		// Makes the file path unique
		String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		
		System.out.println(path + " " + filename);
		
		try {
			
			byte barr[] = file.getBytes();
			
			// Retrieves file data and stores it in a buffer
			BufferedOutputStream bout = new BufferedOutputStream(
						new FileOutputStream(path+"/"+filename));
			
			bout.write(barr);
			bout.flush();
			bout.close();
			
			// Saves the document to the database
			Document document = new Document();
			document.setFilePath(path+"/"+filename);
			document.setTitle(title);
			// set athor to the logged in users id
	        //document.setAuthor(author);
	        
	        DocumentDao.saveDocument(document);
	        	
		} catch(Exception e) {
			System.out.println(e);
		}
			
		return new ModelAndView("upload-success", "filename", path+"/"+filename);
		
	}
}
