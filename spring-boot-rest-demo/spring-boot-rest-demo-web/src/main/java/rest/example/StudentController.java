package rest.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rest.example.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("students")
	public List<StudentDTO> retrieveAllStudents(){
		return studentService.retrieveAllStudents();
	}
	
	@GetMapping(path = "students/{id}")
	public StudentDTO retrieveStudentById(@PathVariable(name = "id") String id) throws StudentNotFoundException{
		try {
			return studentService.retrieveStudentById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
	@GetMapping(path = "students/{id}/marks")
	public StudentDTO retrieveStudentMarksById(@PathVariable(name = "id") String id) throws StudentNotFoundException{
		try {
			return studentService.retrieveStudentMarksById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
	@PostMapping(path = "students")
	public StudentDTO registerStudent(@RequestBody StudentDTO studentDTO){
		return this.studentService.registerStudent(studentDTO);
	}
	
	@PutMapping(path = "students/{id}")
	public StudentDTO updateStudent(@PathVariable("id") String id, @RequestBody StudentDTO studentDTO){
		return this.studentService.updateStudent(id, studentDTO);
	}
	
	@DeleteMapping(path = "students/{id}")
	public StudentDTO deleteStudent(@PathVariable("id") String id){
		return this.studentService.deleteStudent(id);
	}
}
