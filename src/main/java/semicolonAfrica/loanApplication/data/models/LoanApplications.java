package semicolonAfrica.loanApplication.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class LoanApplications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    private Customer customer;
    @Column(nullable = false)
    private BigDecimal bigDecimal;
    @Column(nullable = false)
    private String purpose;
    @Enumerated(EnumType.STRING)
    private LoanPreference loanPreference;
    @Enumerated(EnumType.STRING)
    private LoanApplicationStatus loanApplicationStatus;
    @OneToOne
    private LoanAgreement loanAgreement;
}
