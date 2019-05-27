package se.lnu.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import se.lnu.dao.DocumentDao;
import se.lnu.dao.FileStorageDao;
import se.lnu.entity.AppResponse;
import se.lnu.entity.Document;
import se.lnu.entity.Feedback;
import se.lnu.utils.DocConstants;

@RequestMapping("/document") 
@Controller
public class DocumentController {
    final static Logger LOG = LoggerFactory.getLogger(DocumentController.class);
    
    @Autowired
    private DocumentDao DocumentDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public Feedback saveFeedback(ModelMap modelMap){

        return null;
    }
    
    /* added by me *****/
    
    ObjectMapper objectMapper = new ObjectMapper(); // provides functionality for reading and writing JSON
	@Autowired
	FileStorageDao fileStorageDao;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	//@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public AppResponse createDocument(@Valid
			@RequestParam(value = DocConstants.DOCUMENT_JSON_PARAM, required = true) String docJson,
			@RequestParam(required = true, value = DocConstants.DOCUMENT_FILE_PARAM) MultipartFile file)
			throws JsonParseException, JsonMappingException, IOException {
		String fileName = fileStorageDao.storeFile(file); 
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/document" + DocConstants.DOWNLOAD_PATH)
				.path(fileName).toUriString();

		Document document = objectMapper.readValue(docJson, Document.class);
		document.setFilePath(fileDownloadUri);
		DocumentDao.saveDocument(document);

		return new AppResponse(DocConstants.SUCCESS_CODE, DocConstants.SUCCESS_MSG);
	}

    
}
