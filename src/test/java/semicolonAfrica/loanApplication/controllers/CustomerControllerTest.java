package semicolonAfrica.loanApplication.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import semicolonAfrica.loanApplication.data.models.LoanPreference;
import semicolonAfrica.loanApplication.dtos.requests.CustomerRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoanRequest;
import semicolonAfrica.loanApplication.dtos.requests.LoginRequest;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
  private   ObjectMapper objectMapper ;
    private  CustomerRequest request ;
    private LoginRequest loginRequest;

    private LoanRequest loanRequest;

    @BeforeEach
    void setup(){
        objectMapper = new ObjectMapper();
        request = new CustomerRequest();
        loginRequest = new LoginRequest();

        request.setFirstname("Anthony");
        request.setLastname("Miracle");
        request.setEmail("tonyracle@gmail.com");
        request.setPhoneNumber("07044223344");
        request.setPassword("password20");
        request.setAge(20);
        request.setAddress("No 19,sabo lagos mainland");

        loginRequest = new LoginRequest();
        loginRequest.setEmail("tonyracle@gmail.com");
        loginRequest.setPassword("password20");

        loanRequest = new LoanRequest();
        loanRequest.setCustomerId(1L);
        loanRequest.setAmount(new BigDecimal("500000"));
        loanRequest.setPurpose("School fees");
        loanRequest.setLoanPreference(LoanPreference.WEEKLY);

    }





    @Test
    public void registerTest(){


        try{
            mockMvc.perform(post("/api/v1/customer/register").
                    content(objectMapper.writeValueAsBytes(request)).
                    contentType(MediaType.APPLICATION_JSON)).
                    andExpect(status().is2xxSuccessful()).
                    andDo(print());

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }



    @Test
    public void loginTest(){
       try{
           mockMvc.perform(post("/api/v1/customer/login").
                   content(objectMapper.writeValueAsBytes(loginRequest)).
                   contentType(MediaType.APPLICATION_JSON)).
                   andExpect(status().is2xxSuccessful()).
                   andDo(print());
       }catch (Exception exception){
           exception.printStackTrace();
       }

    }



    @Test
    public void customerCanApplyForLoanTest(){
    try{
        mockMvc.perform(post("/api/v1/customer/loanApplication").
                content(objectMapper.writeValueAsBytes(loanRequest)).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().is2xxSuccessful()).
                andDo(print());
    }catch (Exception exception){
        exception.printStackTrace();
}
}
}