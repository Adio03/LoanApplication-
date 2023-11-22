package semicolonAfrica.loanApplication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import semicolonAfrica.loanApplication.data.models.LoanAgreement;
import semicolonAfrica.loanApplication.data.models.LoanApplications;
import semicolonAfrica.loanApplication.data.repositories.LoanAgreementRepository;
import semicolonAfrica.loanApplication.dtos.requests.LoanAgreementRequest;
import semicolonAfrica.loanApplication.dtos.responses.LoanAgreementResponse;
import semicolonAfrica.loanApplication.exception.LoanNotFoundException;

@Service
@AllArgsConstructor
public class LoanAgreementServiceImpl implements LoanAgreementService{
    private final LoanAgreementRepository loanAgreementRepository;
    private final LoanApplicationsService loanApplicationsService;


  public LoanAgreementResponse generateLoanAgreement(LoanAgreementRequest loanAgreementRequest) throws LoanNotFoundException {
      Long loanId = loanAgreementRequest.getLoanApplicationId();
      LoanApplications loanApplications =loanApplicationsService.findLoanById(loanId).
              orElseThrow(()->new LoanNotFoundException("Loan not found"));

        LoanAgreement loanAgreement = new LoanAgreement();
        loanAgreement.setInterestRate(loanAgreementRequest.getInterestRate());
        loanAgreement.setLoanTerm(loanAgreementRequest.getLoanTerm());
        loanAgreement.setLoanApplications(loanApplications);

        var savedAgreement = loanAgreementRepository.save(loanAgreement);
        LoanAgreementResponse loanAgreementResponse = new LoanAgreementResponse();
        loanAgreementResponse.setAmount(savedAgreement.getLoanApplications().getAmount());
        loanAgreementResponse.setInterestRate(savedAgreement.getInterestRate());
        loanAgreementResponse.setLoanTerm(savedAgreement.getLoanTerm());
      System.out.println(loanAgreementResponse);

        return loanAgreementResponse;
    }
}
