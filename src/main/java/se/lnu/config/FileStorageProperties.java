package se.lnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import se.lnu.utils.DocConstants;

@Component("fileStorageProperties")
@ConfigurationProperties(prefix = DocConstants.FILE_PROPERTIES_PREFIX)
public class FileStorageProperties {
	
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}
	
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

}
