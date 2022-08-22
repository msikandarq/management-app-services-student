package management.app.services.student.model;

/**
 * @author Sikandar
 *
 */
public class PaymentResponse {
	private String transactionReference;
	private String timestamp;

	public String getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
