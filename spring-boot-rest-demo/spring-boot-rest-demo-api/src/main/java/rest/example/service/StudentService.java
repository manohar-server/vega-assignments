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
	 * @return created StudentDTO
	 */
	StudentDTO registerStudent(StudentDTO studentDTO);

	/***
	 * Service Method to update Student Info of the Specified id
	 * @param id the student id, studentDTO the student information to update
	 * @return updated Student Information
	 */
	StudentDTO updateStudent(String id, StudentDTO studentDTO);

	/***
	 * Service Method to fetch Student Marks of the Specified Student
	 * @param studentDTO the student information to save
	 * @return StudentDTO information with marks list
	 */
	StudentDTO retrieveStudentMarksById(long parseLong);

	/***
	 * Service Method to delete Student 
	 * @param id the student to delete
	 * @return StudentDTO information with marks list
	 */
	StudentDTO deleteStudent(String id);

																										
}
