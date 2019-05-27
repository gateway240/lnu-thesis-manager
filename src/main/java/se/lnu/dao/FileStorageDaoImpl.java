package se.lnu.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import se.lnu.config.FileStorageProperties;
import se.lnu.exception.FileStorageException;
import se.lnu.exception.MyFileNotFoundException;
import se.lnu.utils.DocConstants;

import org.springframework.util.StringUtils;

@Service
public class FileStorageDaoImpl {
	
	private final Path fileStorageLocation;
	
	// the constructor is autowired so it will create the folder when the application starts
	@Autowired
	public FileStorageDaoImpl(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize(); // blir fel

		try {
			// when application start the upload folder is created
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException(DocConstants.FILE_STORAGE_EXCEPTION_PATH_NOT_FOUND, ex);
		}
	}

	public String storeFile(MultipartFile file) throws IOException {
		
		if (!(file.getOriginalFilename().endsWith(DocConstants.PDF_FILE_FORMAT)))
			throw new FileStorageException(DocConstants.INVALID_FILE_FORMAT);
		
		File f = new File(DocConstants.TEMP_DIR+file.getOriginalFilename());
		
		f.createNewFile(); 
		FileOutputStream fout = new FileOutputStream(f);
		fout.write(file.getBytes());
		fout.close();
		
		if(f.exists())
		   f.delete();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (fileName.contains(DocConstants.INVALID_FILE_DELIMITER)) {
				throw new FileStorageException(DocConstants.INVALID_FILE_PATH_NAME + fileName);
			}
			String newFileName = System.currentTimeMillis() + DocConstants.FILE_SEPERATOR + fileName;
			Path targetLocation = this.fileStorageLocation.resolve(newFileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return newFileName;
		} catch (IOException ex) {
			throw new FileStorageException(String.format(DocConstants.FILE_STORAGE_EXCEPTION, fileName), ex);
		}

	}
	
	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException(DocConstants.FILE_NOT_FOUND + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException(DocConstants.FILE_NOT_FOUND + fileName, ex);
		}
	}


}
