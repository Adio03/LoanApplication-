package semicolonAfrica.loanApplication.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import semicolonAfrica.loanApplication.LoanApplication;
import semicolonAfrica.loanApplication.data.models.LoanApplications;

public interface LoanApplicationsRepository extends JpaRepository<LoanApplications, Long> {
    LoanApplication findLoanApplicationsByCustomerId(Long customerId);
}
