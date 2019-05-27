package se.lnu.utils;

public class DocConstants {
	
	public static final String DOCUMENT_JSON_PARAM = "docJson";
	public static final String DOCUMENT_FILE_PARAM = "file";
	public static final String SUCCESS_CODE = "200";
	public static final String SUCCESS_MSG = "Document created successfully";
	public static final String FILE_SEPERATOR = "_";
	public static final String DOWNLOAD_PATH = "/downloadFile/";
	public static final String DOWNLOAD_URI = "/downloadFile/{fileName:.+}";
	public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
	public static final String FILE_DOWNLOAD_HTTP_HEADER = "attachment; filename=\"%s\"";
	public static final String FILE_PROPERTIES_PREFIX = "file";
	public static final String FILE_STORAGE_EXCEPTION_PATH_NOT_FOUND = "Could not create the directory where the uploaded files will be stored";
	public static final String INVALID_FILE_PATH_NAME = "Sorry! Filename contains invalid path sequence";
	public static final String FILE_NOT_FOUND = "File not found ";
	public static final String FILE_STORAGE_EXCEPTION = "Could not store file %s !! Please try again!";
	public static final CharSequence INVALID_FILE_DELIMITER = "..";
	public static final String TEMP_DIR = "C:\\Users\\webbe\\thesis\\lnu-thesis-manager\\upload";
	public static final String PDF_FILE_FORMAT = ".pdf";
	public static final String INVALID_FILE_FORMAT = "Only PDF-files are allowed";

}
