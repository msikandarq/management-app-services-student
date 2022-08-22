package management.app.services.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import management.app.services.student.constant.PaymentType;
import management.app.services.student.entity.StudentEntity;
import management.app.services.student.model.Fees;
import management.app.services.student.model.FeesResponse;
import management.app.services.student.model.PaymentResponse;
import management.app.services.student.service.FeesService;
import management.app.services.student.service.StudentService;

@Service
public class FeesServiceImpl implements FeesService {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${PAYMENT_HOST}")
	private String paymentHost;
	
	@Value("${PAYMENT_URI}")
	private String paymentUri;
	
	public FeesResponse payFees(Fees fees) {
		String studentId = fees.getStudentId();
		StudentEntity student = studentService.getStudent(studentId);
		if (student == null) {
			// exception
		}
		
		// call payment service
		HttpEntity<Fees> request = new HttpEntity<>(fees);
		ResponseEntity<PaymentResponse> paymentResponseEntity = restTemplate.postForEntity(paymentHost + paymentUri, request, PaymentResponse.class);
		if (!paymentResponseEntity.getStatusCode().is2xxSuccessful()) {
			// throw exception
		}
		
		PaymentResponse paymentResponse = paymentResponseEntity.getBody();
		// preparing receipt
		FeesResponse feesResponse = new FeesResponse();
		feesResponse.setAmount(fees.getAmount());
		if (PaymentType.CARD.name().equalsIgnoreCase(fees.getPaymentMode())) {
			feesResponse.setCardNumber(fees.getCardNumber());
			// based on bin need can identify the card type
			feesResponse.setCardType("VISA");
		}
		feesResponse.setGrade(student.getGrade());
		feesResponse.setSchoolName(student.getSchoolName());
		feesResponse.setStudentId(student.getStudentId());
		feesResponse.setStudentName(student.getName());
		feesResponse.setTimeStamp(paymentResponse.getTimestamp());
		feesResponse.setTransactionReference(paymentResponse.getTransactionReference());
		return feesResponse;
	}
}
