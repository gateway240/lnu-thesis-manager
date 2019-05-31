package se.lnu.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/download")
public class FileDownloadController {
	
	final static Logger LOG = LoggerFactory.getLogger(FileDownloadController.class);
	
    @RequestMapping(value="/pdf/{fileName:.+}", method=RequestMethod.GET)
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable("fileName") String fileName)
    {
        //If user is not authorized - the user should be thrown out
         
        //Authorized user will download the file
    	
    	// Sets the file path where the files are available
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
        // Sets the file path to the specific file
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file))
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
            	// Read the data of the file and and send it to a output stream
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}