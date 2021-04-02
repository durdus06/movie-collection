package durdu.projects.moviecollection.exception;

import java.io.Serializable;

public class GenreNotFoundException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private String message;
	
	public GenreNotFoundException() {
		this("Genre is not available!");
	}
	public GenreNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}
	public String getMessage() {
		return message;
	}	

}
