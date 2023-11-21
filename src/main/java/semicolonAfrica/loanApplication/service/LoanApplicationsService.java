package semicolonAfrica.loanApplication.service;

import org.springframework.data.jpa.repository.Query;
import semicolonAfrica.loanApplication.data.models.LoanApplications;
import semicolonAfrica.loanApplication.dtos.responses.LoanApplicationResponse;
import semicolonAfrica.loanApplication.exception.CustomerNotFound;

import java.util.List;
import java.util.Optional;

public interface LoanApplicationsService {
    LoanApplicationResponse appliedLoan(LoanApplications loanApplications) throws CustomerNotFound;
    Optional<LoanApplications> findLoanById(Long loanId);
    @Query("""
            select loan from LoanApplications loan
            where loan.loanApplicationStatus = "PENDING"
            """)
    List<LoanApplications> viewAllLoanApplication();

}
