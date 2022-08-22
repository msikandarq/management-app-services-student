package management.app.services.student.service;

import management.app.services.student.entity.StudentEntity;
import management.app.services.student.model.Student;

public interface StudentService {

	void registerStudent(Student student);
	
	StudentEntity getStudent(String studentId);
}
