package semicolonAfrica.loanApplication.dtos.responses;

import lombok.Getter;

@Getter
public class LoginResponse {
    private String message;

    public String getMessage(){
        return "Successfully logged in ";
    }
}
