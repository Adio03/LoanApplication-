package semicolonAfrica.loanApplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import semicolonAfrica.loanApplication.data.models.LoanApplicationStatus;
import semicolonAfrica.loanApplication.data.models.LoanPreference;
import semicolonAfrica.loanApplication.dtos.requests.CustomerRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoanRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoginRequest;
import semicolonAfrica.loanApplication.dtos.responses.CustomerResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoanApplicationResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoginResponse;
import semicolonAfrica.loanApplication.exception.CustomerAlreadyExist;
import semicolonAfrica.loanApplication.exception.CustomerNotFound;


import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class
CustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    private CustomerRequest customerRequest;
    private CustomerResponse customerResponse;
    private LoginRequest loginRequest;
    private LoginResponse loginResponse;
    private LoanRequest loanRequest;

    @BeforeEach
    void setUp() throws CustomerAlreadyExist{
        customerRequest= new CustomerRequest();

        customerRequest.setFirstname("Anthony");
        customerRequest.setLastname("Miracle");
        customerRequest.setEmail("tonyMiracle@gmail.com");
        customerRequest.setPhoneNumber("07011223344");
        customerRequest.setPassword("password");
        customerRequest.setAge(20);


        loginRequest = new LoginRequest();
        loginRequest.setEmail("tonyMiracle@gmail.com");
        loginRequest.setPassword("password");

        loanRequest = new LoanRequest();
        loanRequest.setCustomerId(1L);
        loanRequest.setAmount(new BigDecimal("500000"));
        loanRequest.setPurpose("School fees");
        loanRequest.setLoanPreference(LoanPreference.WEEKLY);

    }

    @Test
    public void registerCustomerTest() throws CustomerAlreadyExist {
        customerResponse = customerService.register(customerRequest);
        assertNotNull(customerResponse);
        assertNotNull(customerResponse.getMessage());


    }
@Test
    public void loginTest() throws CustomerNotFound {
     loginResponse  = customerService.login(loginRequest);
     assertNotNull(loginResponse);
     assertNotNull(loginResponse.getMessage());

}
    @Transactional
    @Rollback(false)
    @Test
    public void applyLoanTest() throws CustomerNotFound {
        LoanApplicationResponse  loanApplicationResponse = customerService.applyForLoan(loanRequest);
        assertNotNull(loanApplicationResponse);
        assertNotNull(loanApplicationResponse.getLoanId());
        assertNotNull(loanApplicationResponse.getCustomerId());

    }

@Test
    public void customerCanCheckLoanStatus() throws CustomerNotFound {
        Long loanId = 6L;
        Long customerId=1L;

    LoanApplicationStatus loanApplicationResponse = customerService.viewLoanStatus(customerId,loanId);
        assertNotNull(loanApplicationResponse);


}

}
