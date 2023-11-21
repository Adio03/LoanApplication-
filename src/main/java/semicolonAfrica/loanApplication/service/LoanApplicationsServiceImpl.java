package semicolonAfrica.loanApplication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import semicolonAfrica.loanApplication.data.models.LoanApplications;
import semicolonAfrica.loanApplication.data.repositories.LoanApplicationsRepository;
import semicolonAfrica.loanApplication.dtos.responses.LoanApplicationResponse;
import semicolonAfrica.loanApplication.exception.CustomerNotFound;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanApplicationsServiceImpl implements LoanApplicationsService {

    private final LoanApplicationsRepository loanApplicationsRepository;



    @Override
    public LoanApplicationResponse appliedLoan(LoanApplications  loanApplications) throws CustomerNotFound {
       var savedLoan = loanApplicationsRepository.save(loanApplications);
       LoanApplicationResponse loanApplicationResponse = new LoanApplicationResponse();
       loanApplicationResponse.setLoanId(savedLoan.getId());
       loanApplicationResponse.setCustomerId(savedLoan.getId());
       loanApplicationResponse.setAmount(savedLoan.getBigDecimal());
       return loanApplicationResponse;
    }

    @Override
    public Optional<LoanApplications> findLoanById(Long loanId) {
        return loanApplicationsRepository.findById(loanId);
    }

    @Override
    public List<LoanApplications> viewAllLoanApplication() {
        return loanApplicationsRepository.findAll();
    }



}
