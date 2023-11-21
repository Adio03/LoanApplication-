package semicolonAfrica.loanApplication.service;

import org.springframework.data.domain.Page;
import semicolonAfrica.loanApplication.data.models.LoanApplications;
import semicolonAfrica.loanApplication.dtos.requests.LoanOfficeDetailRequests;
import semicolonAfrica.loanApplication.dtos.responses.LoanAgreementResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoanApplicationResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoginResponse;
import semicolonAfrica.loanApplication.exception.InvalidCredentialException;

import java.util.List;

public interface LoanOfficerService {

  LoginResponse loginLoanOfficer(LoanOfficeDetailRequests loanOfficeDetailRequests) throws InvalidCredentialException;
  Page<LoanApplications> viewAll_LoanApplication(int page);
  LoanAgreementResponse generateResponse(Long loanId);
}
