package semicolonAfrica.loanApplication.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import semicolonAfrica.loanApplication.data.models.LoanPreference;

import java.math.BigDecimal;

@Setter
@Getter
public class LoanRequest {
    private CustomerRequest customerRequest;
    private BigDecimal amount;
    private String purpose;
    private LoanPreference loanPreference;


}
