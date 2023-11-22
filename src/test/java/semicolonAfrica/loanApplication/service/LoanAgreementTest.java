package semicolonAfrica.loanApplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolonAfrica.loanApplication.data.models.LoanPreference;
import semicolonAfrica.loanApplication.dtos.requests.CustomerRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoanAgreementRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoanRequest;
import semicolonAfrica.loanApplication.dtos.responses.LoanAgreementResponse;
import semicolonAfrica.loanApplication.exception.LoanNotFoundException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LoanAgreementTest {
    @Autowired
    private LoanAgreementService loanAgreementService;
    private CustomerRequest customerRequest;
    private LoanRequest loanRequest;
    private LoanAgreementRequest loanAgreementRequest;

    @BeforeEach
    void setUp(){
        customerRequest= new CustomerRequest();

        customerRequest.setFirstname("Anthony");
        customerRequest.setLastname("Miracle");
        customerRequest.setEmail("tonyMiracle@gmail.com");
        customerRequest.setPhoneNumber("07011223344");
        customerRequest.setPassword("password");
        customerRequest.setAge(20);
        customerRequest.setAddress("No 19,sabo lagos mainland");

        loanRequest = new LoanRequest();
        loanRequest.setCustomerId(100L);
        loanRequest.setAmount(new BigDecimal("500000"));
        loanRequest.setPurpose("School fees");
        loanRequest.setLoanPreference(LoanPreference.WEEKLY);

        loanAgreementRequest =new LoanAgreementRequest();
        loanAgreementRequest.setLoanApplicationId(1L);
        loanAgreementRequest.setInterestRate(20.0);
        loanAgreementRequest.setLoanTerm("Four month and four weeks");

    }

    @Test
    public void loanAgreementTest() throws LoanNotFoundException {
        LoanAgreementResponse loanAgreementResponse = loanAgreementService.
                generateLoanAgreement(loanAgreementRequest);
        assertNotNull(loanAgreementResponse);
        assertNotNull(loanAgreementResponse.getAmount());
        assertNotNull(loanAgreementResponse.getLoanTerm());

    }
}
