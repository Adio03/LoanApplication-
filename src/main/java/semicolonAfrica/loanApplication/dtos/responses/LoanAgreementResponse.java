package semicolonAfrica.loanApplication.dtos.responses;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Setter
@Getter
@ToString
public class LoanAgreementResponse {

    private BigDecimal amount;
    private double interestRate;
    private String loanTerm;
}
