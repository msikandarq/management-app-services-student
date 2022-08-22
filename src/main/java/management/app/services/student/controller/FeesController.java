package management.app.services.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import management.app.services.student.model.Fees;
import management.app.services.student.model.FeesResponse;
import management.app.services.student.service.FeesService;

/**
 * @author Sikandar
 *
 */
@RestController
@RequestMapping("/v1")
public class FeesController {

	@Autowired
	private FeesService feesService;
	
	@PostMapping("/fees")
	public ResponseEntity<FeesResponse> payFees(@RequestBody Fees fees) {
		FeesResponse feesResponse = feesService.payFees(fees);
		return new ResponseEntity<>(feesResponse, HttpStatus.OK);
	}
}
