package semicolonAfrica.loanApplication.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int age;
    private boolean isLogin;
    @OneToMany
    private List<LoanApplications> loanApplications;

}
