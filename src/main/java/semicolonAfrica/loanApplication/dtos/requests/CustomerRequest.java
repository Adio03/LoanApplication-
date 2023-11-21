package semicolonAfrica.loanApplication.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private int age;
    private String password;
    private String address;
}
