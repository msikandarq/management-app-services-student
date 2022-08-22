package management.app.services.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import management.app.services.student.entity.StudentEntity;
import management.app.services.student.model.Student;
import management.app.services.student.repository.StudentRepository;
import management.app.services.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public void registerStudent(Student student) {
		StudentEntity studentEntity = new  StudentEntity();
		studentEntity.setStudentId(student.getId());
		studentEntity.setName(student.getName());
		studentEntity.setGrade(student.getGrade());
		studentEntity.setMobileNumber(student.getMobileNumber());
		studentEntity.setSchoolName(student.getSchoolName());
		studentRepository.save(studentEntity);
	}

	@Override
	public StudentEntity getStudent(String studentId) {
		return studentRepository.findByStudentId(studentId);
	}
}
