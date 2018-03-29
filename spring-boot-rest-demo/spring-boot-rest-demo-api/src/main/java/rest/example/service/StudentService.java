package rest.example.service;

import java.util.List;

import rest.example.StudentDTO;

/***
 * Student Service 
 * @author Manohar
 *
 */
public interface StudentService{

	/***
	 *  Service Method to fetch all Students 
	 * @return List of All Students
	 */
	List<StudentDTO> retrieveAllStudents();

	/***
	 * Service Method to fetch Student Info of the Specified id
	 * @param id => student Id
	 * @return Student Details 
	 */
	StudentDTO retrieveStudentById(long id);

	
	/***
	 * Service Method to fetch Student Info of the Specified id
	 * @param studentDTO the student information to save
	 * @return
	 */
	StudentDTO registerStudent(StudentDTO studentDTO);

	StudentDTO updateStudent(StudentDTO studentDTO);

	StudentDTO retrieveStudentMarksById(long parseLong);

}
