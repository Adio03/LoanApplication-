package semicolonAfrica.loanApplication.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class LoanAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private double interestRate;
    @Column(nullable = false)
    private String loanTerm;




}
