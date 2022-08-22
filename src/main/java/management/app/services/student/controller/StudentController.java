package management.app.services.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import management.app.services.student.model.Student;
import management.app.services.student.service.StudentService;

/**
 * @author Sikandar
 *
 */
@RestController
@RequestMapping("/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/details")
	public ResponseEntity<?> register(@RequestBody Student student) {
		studentService.registerStudent(student);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
}
