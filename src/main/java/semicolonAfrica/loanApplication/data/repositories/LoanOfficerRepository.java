package semicolonAfrica.loanApplication.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import semicolonAfrica.loanApplication.data.models.LoanOfficer;

import java.util.Optional;

public interface LoanOfficerRepository extends JpaRepository<LoanOfficer,Long> {

    Optional<LoanOfficer> findByUsername(String username);
}
