package semicolonAfrica.loanApplication.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static semicolonAfrica.loanApplication.utils.PasswordEncoder.hashPassword;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class LoanOfficer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username ;
    @Column(nullable = false)
    private String password ;
    private boolean isLoanOfficerLogin;





}
