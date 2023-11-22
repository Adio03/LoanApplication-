package semicolonAfrica.loanApplication.service;

import semicolonAfrica.loanApplication.dtos.requests.LoanAgreementRequest;
import semicolonAfrica.loanApplication.dtos.responses.LoanAgreementResponse;
import semicolonAfrica.loanApplication.exception.LoanNotFoundException;

public interface LoanAgreementService {
    LoanAgreementResponse generateLoanAgreement(LoanAgreementRequest loanAgreementRequest) throws LoanNotFoundException;
}
