package semicolonAfrica.loanApplication.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter

public class CustomerResponse {
    private String message;

    public String getMessage(){
         return  "Successfully Registered";
    }
}
