package semicolonAfrica.loanApplication.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import semicolonAfrica.loanApplication.data.models.LoanAgreement;

public interface LoanAgreementRepository extends JpaRepository<LoanAgreement,Long> {
}
