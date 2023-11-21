package semicolonAfrica.loanApplication.service;

import semicolonAfrica.loanApplication.dtos.requests.LoanAgreementRequest;
import semicolonAfrica.loanApplication.dtos.responses.LoanAgreementResponse;

public interface LoanAgreementService {
    LoanAgreementResponse generateLoanAgreement(LoanAgreementRequest loanAgreementRequest);
}
