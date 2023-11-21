package semicolonAfrica.loanApplication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import semicolonAfrica.loanApplication.data.models.LoanAgreement;
import semicolonAfrica.loanApplication.data.repositories.LoanAgreementRepository;
import semicolonAfrica.loanApplication.dtos.requests.LoanAgreementRequest;
import semicolonAfrica.loanApplication.dtos.responses.LoanAgreementResponse;
@Service
@AllArgsConstructor
public class LoanAgreementServiceImpl implements LoanAgreementService{
    private final LoanAgreementRepository loanAgreementRepository;

  public LoanAgreementResponse generateLoanAgreement(LoanAgreementRequest loanAgreementRequest) {
        LoanAgreement loanAgreement = new LoanAgreement();
        loanAgreement.setAmount(loanAgreementRequest.getAmount());
        loanAgreement.setInterestRate(loanAgreementRequest.getInterestRate());
        loanAgreement.setLoanTerm(loanAgreementRequest.getLoanTerm());

        var savedAgreement = loanAgreementRepository.save(loanAgreement);
        LoanAgreementResponse loanAgreementResponse = new LoanAgreementResponse();
        loanAgreementResponse.setAmount(savedAgreement.getAmount());
        loanAgreementResponse.setInterestRate(savedAgreement.getInterestRate());
        loanAgreementResponse.setLoanTerm(savedAgreement.getLoanTerm());

        return loanAgreementResponse;
    }
}
