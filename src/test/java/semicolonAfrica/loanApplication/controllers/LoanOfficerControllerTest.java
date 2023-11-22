package semicolonAfrica.loanApplication.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import semicolonAfrica.loanApplication.dtos.requests.LoanOfficeDetailRequests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoanOfficerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private LoanOfficeDetailRequests loanOfficeDetailRequests;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        loanOfficeDetailRequests = new LoanOfficeDetailRequests();
        loanOfficeDetailRequests.setUsername("loanOfficer");
        loanOfficeDetailRequests.setPassword("loanOfficerPassword");
    }
    @Test
    public void loanOfficerLoginTest(){
        try{
            mockMvc.perform(post("/api/v1/loanOfficer/login").
                    content(objectMapper.writeValueAsBytes(loanOfficeDetailRequests)).
                    contentType(MediaType.APPLICATION_JSON)).
                    andExpect(status().is2xxSuccessful()).
                    andDo(print());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
