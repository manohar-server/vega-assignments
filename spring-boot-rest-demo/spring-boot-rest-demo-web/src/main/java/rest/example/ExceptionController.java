package rest.example;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import rest.example.StudentNotFoundException;

@ControllerAdvice("rest.example")
@RequestMapping(produces = "application/json")
public class ExceptionController {

	@ExceptionHandler(StudentNotFoundException.class)
	  public StudentNotFoundException notFoundException(final StudentNotFoundException e) {
		System.err.println("K...........");
	    return e;
	  }
}
