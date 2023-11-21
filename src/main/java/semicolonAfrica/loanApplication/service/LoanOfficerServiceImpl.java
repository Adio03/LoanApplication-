package semicolonAfrica.loanApplication.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import semicolonAfrica.loanApplication.data.models.LoanApplications;
import semicolonAfrica.loanApplication.data.models.LoanOfficer;
import semicolonAfrica.loanApplication.data.repositories.LoanOfficerRepository;
import semicolonAfrica.loanApplication.dtos.requests.LoanOfficeDetailRequests;
import semicolonAfrica.loanApplication.dtos.responses.LoanAgreementResponse;
import semicolonAfrica.loanApplication.dtos.responses.LoginResponse;
import semicolonAfrica.loanApplication.exception.InvalidCredentialException;

import java.util.List;

import static semicolonAfrica.loanApplication.utils.PasswordEncoder.hashPassword;

@Service
@AllArgsConstructor
public class LoanOfficerServiceImpl implements LoanOfficerService{
    private static final int MAX_NUMBER_PER_PAGE = 1;
    private  LoanOfficerRepository loanOfficerRepository;
    private final LoanApplicationsService loanApplicationsService;
    private final LoanAgreementService loanAgreementService;


    @Override
    public LoginResponse loginLoanOfficer(LoanOfficeDetailRequests loanOfficeDetailRequests) throws InvalidCredentialException {
LoanOfficer loanOfficer =loanOfficerRepository.findByUsername(loanOfficeDetailRequests.getUsername()).
                orElseThrow(() -> new InvalidCredentialException("invalid username or password"));
    boolean isPasswordCorrect = loanOfficer.getPassword().equals(hashPassword(loanOfficeDetailRequests.getPassword()));
    if (isPasswordCorrect){
        loanOfficer.setLoanOfficerLogin(true);
        loanOfficerRepository.save(loanOfficer);
        return new LoginResponse();

    }else throw new InvalidCredentialException("invalid username or password");

    }

    @Override
    public Page<LoanApplications> viewAll_LoanApplication(int page) {
        Pageable  pageable = PageRequest.of(page-1,MAX_NUMBER_PER_PAGE);
        List<LoanApplications> loanPage = loanApplicationsService.viewAllLoanApplication();
        return new PageImpl<>(loanPage,pageable,loanPage.size());
        
    }

    @Override
    public LoanAgreementResponse generateResponse(Long loanId) {
        return null;
    }


}

    
