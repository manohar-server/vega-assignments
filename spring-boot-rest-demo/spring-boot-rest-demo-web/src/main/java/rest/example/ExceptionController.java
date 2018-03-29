package rest.example;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("rest.example")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionController {

	@ExceptionHandler(StudentNotFoundException.class)
	  public ResponseEntity<StudentNotFoundException> sutdentNotFoundException(final StudentNotFoundException e) {
		return ResponseEntity.ok().body(e);
	  }
}
