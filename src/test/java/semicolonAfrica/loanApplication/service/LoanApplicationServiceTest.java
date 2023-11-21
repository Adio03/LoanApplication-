package semicolonAfrica.loanApplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolonAfrica.loanApplication.data.models.LoanPreference;
import semicolonAfrica.loanApplication.dtos.requests.CustomerRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoanRequest;
import semicolonAfrica.loanApplication.dtos.responses.LoanApplicationResponse;
import semicolonAfrica.loanApplication.exception.CustomerNotFound;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static semicolonAfrica.loanApplication.data.models.LoanPreference.DAILY;
import static semicolonAfrica.loanApplication.data.models.LoanPreference.WEEKLY;

@SpringBootTest
public class LoanApplicationServiceTest {
    @Autowired

    private LoanApplicationsService loanApplicationsService;
    private LoanRequest loanRequest;
    private CustomerRequest customerRequest;
    private LoanApplicationResponse loanApplicationResponse;
@BeforeEach
    void  setup(){
    loanRequest = new LoanRequest();

    customerRequest= new CustomerRequest();
//
//    customerRequest.setFirstname("Anthony");
//    customerRequest.setLastname("Miracle");
//    customerRequest.setEmail("tonyMiracle@gmail.com");
//    customerRequest.setPhoneNumber("07011223344");
//    customerRequest.setPassword("password");
//    customerRequest.setAge(20);
//    customerRequest.setAddress("No 19,sabo lagos mainland");
//
//    loanRequest.setCustomerRequest(customerRequest);
//    loanRequest.setAmount(new BigDecimal("100000"));
//    loanRequest.setPurpose("Allowance");
//    loanRequest.setLoanPreference(DAILY);
    customerRequest.setFirstname("Anthony");
    customerRequest.setLastname("Miracle");
    customerRequest.setEmail("tonyMiracle@gmail.com");
    customerRequest.setPhoneNumber("07011223344");
    customerRequest.setPassword("password");
    customerRequest.setAge(20);
    customerRequest.setAddress("No 19,sabo lagos mainland");

    loanRequest = new LoanRequest();
    loanRequest.setCustomerRequest(customerRequest);
    loanRequest.setAmount(new BigDecimal("500000"));
    loanRequest.setPurpose("School fees");
    loanRequest.setLoanPreference(WEEKLY);
}

}
