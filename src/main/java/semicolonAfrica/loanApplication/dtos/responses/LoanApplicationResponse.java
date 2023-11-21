package semicolonAfrica.loanApplication.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import semicolonAfrica.loanApplication.data.models.LoanApplicationStatus;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class LoanApplicationResponse {
    private Long loanId;
    private BigDecimal amount;
    private Long customerId;
    private LoanApplicationStatus loanApplicationStatus;
    private String message;

    public LoanApplicationResponse() {
        this.message = "Loan Application is successful. Kindly wait for Officer Review";
    }


}