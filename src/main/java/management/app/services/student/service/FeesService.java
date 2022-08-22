package management.app.services.student.service;

import management.app.services.student.model.Fees;
import management.app.services.student.model.FeesResponse;

public interface FeesService {

	/**
	 * @param fees
	 * @return
	 */
	FeesResponse payFees(Fees fees);
}
