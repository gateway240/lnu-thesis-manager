package se.lnu.entity;

public class AppResponse {
	
	private String code;
	private String message;
	//private Exception ex;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public AppResponse() {

	}

	public AppResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}
	/*public AppResponse(Exception ex) {
		this.ex = ex;
	}*/

}
