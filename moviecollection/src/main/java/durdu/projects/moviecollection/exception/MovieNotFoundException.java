package durdu.projects.moviecollection.exception;


import java.io.Serializable;

public class MovieNotFoundException extends Exception implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public MovieNotFoundException() {
		this("Movie is not available!");
	}
	public MovieNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}
	public String getMessage() {
		return message;
	}	
	
}
