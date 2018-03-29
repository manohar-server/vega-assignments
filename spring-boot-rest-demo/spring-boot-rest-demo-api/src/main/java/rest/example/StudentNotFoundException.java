package rest.example;

public class StudentNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1259680395533005936L;

	public StudentNotFoundException() {
		super();
	}
	
	public StudentNotFoundException(String message){
		super(message);
		
	}
}
