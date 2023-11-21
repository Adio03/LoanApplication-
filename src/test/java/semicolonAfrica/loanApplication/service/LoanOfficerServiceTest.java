package semicolonAfrica.loanApplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolonAfrica.loanApplication.dtos.requests.LoanOfficeDetailRequests;
import semicolonAfrica.loanApplication.dtos.responses.LoanApplicationResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoginResponse;
import semicolonAfrica.loanApplication.exception.InvalidCredentialException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LoanOfficerServiceTest {
    @Autowired
    private LoanOfficerService loanOfficerService;
    private LoanOfficeDetailRequests loanOfficeDetailRequests;
    private LoginResponse loginResponse;

    @BeforeEach
    void setUp(){
        loanOfficeDetailRequests = new LoanOfficeDetailRequests();

        loanOfficeDetailRequests.setUsername("loanOfficer");
        loanOfficeDetailRequests.setPassword("loanOfficerPassword");
    }


    @Test
    public void loanOfficerLogin() throws InvalidCredentialException {
        loginResponse = loanOfficerService.loginLoanOfficer(loanOfficeDetailRequests);
        assertNotNull(loginResponse);
    }
    @Test
    public void viewAllLoanApplicationTest(){

    }

    @Test
    public void viewAll_LoanApplication(){

    }
}
