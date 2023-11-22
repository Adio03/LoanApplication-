package semicolonAfrica.loanApplication.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semicolonAfrica.loanApplication.dtos.requests.LoanOfficeDetailRequests;
import semicolonAfrica.loanApplication.dtos.responses.LoginResponse;
import semicolonAfrica.loanApplication.exception.InvalidCredentialException;
import semicolonAfrica.loanApplication.service.LoanOfficerService;

@RestController
@RequestMapping("/api/v1/loanOfficer")
@AllArgsConstructor
public class LoanOfficerController {
    private LoanOfficerService loanOfficerService;

    @PostMapping("/login")
    public ResponseEntity<?> loanOfficerLogin(@RequestBody LoanOfficeDetailRequests loanOfficeDetailRequests){
        try{
            LoginResponse loginResponse = loanOfficerService.loginLoanOfficer(loanOfficeDetailRequests);
            return new ResponseEntity<>(loginResponse.getMessage(), HttpStatus.OK);
        }catch (InvalidCredentialException credentialException){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(credentialException.getMessage());
        }
    }

}
