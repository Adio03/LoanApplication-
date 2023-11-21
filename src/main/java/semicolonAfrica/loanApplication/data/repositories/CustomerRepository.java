package semicolonAfrica.loanApplication.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import semicolonAfrica.loanApplication.data.models.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

   Optional<Customer> findByEmail(String email);
}