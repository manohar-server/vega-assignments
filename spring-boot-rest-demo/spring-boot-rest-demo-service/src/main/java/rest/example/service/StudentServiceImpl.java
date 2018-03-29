package rest.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.example.MarksDTO;
import rest.example.StudentDTO;
import rest.example.StudentNotFoundException;
import rest.example.dao.StudentRepository;
import rest.example.entity.MarksBO;
import rest.example.entity.StudentBO;

/***
 * 
 * @author Manohar
 * Student Service Method Implementation Class
 */
@Service
public class StudentServiceImpl implements StudentService {

	/***
	 * Student JPA Repository for Student Table Operations
	 */
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<StudentDTO> retrieveAllStudents() {
		List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
		List<StudentBO> studentBOs = this.studentRepository.findAll();
		for (StudentBO studentBO : studentBOs) {
			StudentDTO studentDTO = new StudentDTO();
			BeanUtils.copyProperties(studentBO, studentDTO);
			studentDTOs.add(studentDTO);
		}
		return studentDTOs;
	}

	@Override
	public StudentDTO retrieveStudentById(long id) {
		StudentBO studentBO = this.studentRepository.findOne(id);
		if (studentBO == null) {
			throw new StudentNotFoundException();
		}
		StudentDTO studentDTO = new StudentDTO();
		BeanUtils.copyProperties(studentBO, studentDTO);
		return studentDTO;
	}

	@Override
	public StudentDTO registerStudent(StudentDTO studentDTO) {
		StudentBO studentBO = new StudentBO();
		BeanUtils.copyProperties(studentDTO, studentBO);
		StudentBO newStudentBO = studentRepository.save(studentBO);
		StudentDTO newStudentDTO = new StudentDTO();
		BeanUtils.copyProperties(newStudentBO, newStudentDTO);
		return newStudentDTO;
	}

	@Override
	public StudentDTO updateStudent(String id, StudentDTO studentDTO) {
		try {
			long studentId = Long.parseLong(id);
			StudentBO studentBO = this.studentRepository.findOne(studentId);
			studentDTO.setId(studentId);
			BeanUtils.copyProperties(studentDTO, studentBO);
			studentRepository.save(studentBO);
			return studentDTO;
		} catch (Exception e) {
			throw new StudentNotFoundException("Invalid Student Id");
		}
		
	}

	@Override
	public StudentDTO retrieveStudentMarksById(long studentId) {

		StudentDTO studentDTO = null;

		StudentBO studentBO = this.studentRepository.findOne(studentId);
		if (studentBO == null) {
			throw new StudentNotFoundException();
		}
		studentDTO = new StudentDTO();
		BeanUtils.copyProperties(studentBO, studentDTO);
		
		
		List<MarksDTO> marksDTOs = new ArrayList<MarksDTO>();
		Collection<MarksBO> marksBOs = studentBO.getMarkss();
		for (MarksBO marksBO : marksBOs) {
			MarksDTO marksDTO = new MarksDTO();
			BeanUtils.copyProperties(marksBO, marksDTO);
			marksDTOs.add(marksDTO);
		}
		studentDTO.setMarksDTOs(marksDTOs);
		return studentDTO;
	}

	@Override
	public StudentDTO deleteStudent(String id) {
		try {
			long studentId = Long.parseLong(id);
			StudentBO studentBO = this.studentRepository.findOne(studentId);
			StudentDTO studentDTO = new StudentDTO();
			BeanUtils.copyProperties(studentBO, studentDTO);
			this.studentRepository.delete(studentId);
			return studentDTO;
		} catch (Exception e) {
			throw new StudentNotFoundException("Invalid Student Id");
		}
	}

}
