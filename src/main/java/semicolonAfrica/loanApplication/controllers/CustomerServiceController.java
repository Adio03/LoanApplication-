package semicolonAfrica.loanApplication.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semicolonAfrica.loanApplication.dtos.requests.CustomerRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoanRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoginRequest;
import semicolonAfrica.loanApplication.dtos.responses.CustomerResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoanApplicationResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoginResponse;
import semicolonAfrica.loanApplication.exception.CustomerAlreadyExist;
import semicolonAfrica.loanApplication.exception.CustomerNotFound;
import semicolonAfrica.loanApplication.service.CustomerService;

@RestController @RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerServiceController {
    private CustomerService customerService;


@PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerRequest customerRequest){
        try{
            CustomerResponse response = customerService.register(customerRequest);
            return new ResponseEntity<>(response.getMessage(), HttpStatus.OK);
        }catch (CustomerAlreadyExist exception){;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());


        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginRequest loginRequest){
    try{
        LoginResponse loginResponse = customerService.login(loginRequest);
        return new ResponseEntity<>(loginResponse.getMessage(),HttpStatus.OK);
    }catch (CustomerNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    }
    @PostMapping("/loanApplication")
    public ResponseEntity<?> applyForLoan(@RequestBody LoanRequest loanRequest){
    try {
        LoanApplicationResponse loanApplicationResponse = customerService.applyForLoan(loanRequest);
        return  new ResponseEntity<>(loanApplicationResponse.getMessage(),HttpStatus.OK);
    } catch (CustomerNotFound exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    }

}
