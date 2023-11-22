package semicolonAfrica.loanApplication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import semicolonAfrica.loanApplication.data.models.Customer;
import semicolonAfrica.loanApplication.data.models.LoanApplicationStatus;
import semicolonAfrica.loanApplication.data.models.LoanApplications;
import semicolonAfrica.loanApplication.data.repositories.CustomerRepository;
import semicolonAfrica.loanApplication.dtos.requests.CustomerRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoanRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoginRequest;
import semicolonAfrica.loanApplication.dtos.responses.CustomerResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoanApplicationResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoginResponse;
import semicolonAfrica.loanApplication.exception.CustomerAlreadyExist;
import semicolonAfrica.loanApplication.exception.CustomerNotFound;

import java.util.Optional;

import static semicolonAfrica.loanApplication.data.models.LoanApplicationStatus.PENDING;
import static semicolonAfrica.loanApplication.utils.PasswordEncoder.hashPassword;


@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

   private final LoanApplicationsService loanApplicationsService;

    @Override
    public CustomerResponse register(CustomerRequest customerRequest) throws CustomerAlreadyExist {
        boolean isCustomerExist = customerRepository.findByEmail(customerRequest.getEmail()).isPresent();
        if (isCustomerExist) throw new CustomerAlreadyExist("The customer already exist");

        String encodePassword = hashPassword(customerRequest.getPassword());

        Customer customer = new Customer();
        customer.setFirstname(customerRequest.getFirstname());
        customer.setLastname(customerRequest.getLastname());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setPassword(encodePassword);
        customer.setAge(customerRequest.getAge());
        customerRepository.save(customer);

        return new CustomerResponse();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws CustomerNotFound {
        Customer authenticateCustomer = customerRepository.findByEmail(loginRequest.getEmail()).
                orElseThrow(() -> new CustomerNotFound("the email or password is incorrect"));
        boolean isPasswordCorrect = authenticateCustomer.getPassword().equals(hashPassword(loginRequest.getPassword()));
        if (isPasswordCorrect) {
            authenticateCustomer.setLogin(true);
            customerRepository.save(authenticateCustomer);
        } else throw new CustomerNotFound("the email or the password is incorrect");

        return new LoginResponse();
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public LoanApplicationResponse applyForLoan(LoanRequest loanRequest) throws CustomerNotFound {
        LoanApplications loanApplications = new LoanApplications();
        var customer = customerRepository.findById(loanRequest.getCustomerId()).
                orElseThrow(() -> new CustomerNotFound("customer does not exist"));
        Long extractTheCustomerId = customer.getId();
        if (customer.isLogin()) {
            loanApplications.setCustomerId(extractTheCustomerId);
            loanApplications.setAmount(loanRequest.getAmount());
            loanApplications.setPurpose(loanRequest.getPurpose());
            loanApplications.setLoanPreference(loanRequest.getLoanPreference());
            loanApplications.setLoanApplicationStatus(PENDING);

            LoanApplicationResponse save = loanApplicationsService.appliedLoan(loanApplications);

            LoanApplicationResponse response = new LoanApplicationResponse();
            response.setLoanId(save.getLoanId());
            response.setCustomerId(save.getCustomerId());
            response.setAmount(save.getAmount());

            return response;
        } else throw new CustomerNotFound("Kindly login");
    }

    @Override
    public LoanApplicationStatus viewLoanStatus(Long customerId, Long loanId) throws CustomerNotFound {
        Optional<LoanApplications> loanApplications = loanApplicationsService.findLoanById(loanId);

        if (loanApplications.isPresent()) {
            LoanApplications loanApplication = loanApplications.get();
            Long extractedCustomerId = loanApplication.getCustomerId();

            if (extractedCustomerId.equals(customerId)) {
                LoanApplicationResponse response = new LoanApplicationResponse();
                response.setLoanApplicationStatus(loanApplication.getLoanApplicationStatus());
                System.out.println(response.getLoanApplicationStatus());
                return response.getLoanApplicationStatus();
            }
        } else {
            throw new CustomerNotFound("Customer not found");
        }

        return null;
    }
}