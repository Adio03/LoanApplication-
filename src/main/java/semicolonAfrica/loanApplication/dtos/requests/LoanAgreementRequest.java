package semicolonAfrica.loanApplication.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanAgreementRequest {
    private double interestRate;
    private String loanTerm;
    private Long LoanApplicationId;
}
