package semicolonAfrica.loanApplication.service;

import semicolonAfrica.loanApplication.data.models.Customer;
import semicolonAfrica.loanApplication.data.models.LoanApplicationStatus;
import semicolonAfrica.loanApplication.dtos.requests.CustomerRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoanRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoginRequest;
import semicolonAfrica.loanApplication.dtos.responses.CustomerResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoanApplicationResponse;
import semicolonAfrica.loanApplication.exception.CustomerAlreadyExist;
import semicolonAfrica.loanApplication.dtos.responses.LoginResponse;
import semicolonAfrica.loanApplication.exception.CustomerNotFound;

import java.util.Optional;


public interface CustomerService {
    CustomerResponse register(CustomerRequest customerRequest) throws CustomerAlreadyExist, CustomerAlreadyExist;
    LoginResponse login (LoginRequest loginRequest) throws CustomerNotFound;
    Optional<Customer> findCustomerByEmail(String email);
    LoanApplicationResponse applyForLoan(LoanRequest loanRequest) throws CustomerNotFound;
   LoanApplicationStatus viewLoanStatus(Long customerId, Long loanId) throws CustomerNotFound;
}
