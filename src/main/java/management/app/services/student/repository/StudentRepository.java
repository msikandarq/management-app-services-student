package management.app.services.student.repository;

import org.springframework.data.repository.CrudRepository;

import management.app.services.student.entity.StudentEntity;

/**
 * @author Sikandar
 *
 */
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
	
	/**
	 * @param studentId
	 * @return
	 */
	StudentEntity findByStudentId(String studentId);
}
