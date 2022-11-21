package stewart.jonathan.InvestmentTracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import stewart.jonathan.InvestmentTracker.model.Investment;
import stewart.jonathan.InvestmentTracker.service.InvestmentService;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvestmentController.class)
public class ControllerTest {

    @MockBean
    InvestmentService investmentService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_new_investment() throws Exception {

        Investment newInvestment = new Investment();
        newInvestment.setId("TEST");
        newInvestment.setCompany("Testing Company");
        newInvestment.setShares(123F);

        Investment investment = new Investment();
        investment.setId(newInvestment.getId());
        investment.setCompany(newInvestment.getCompany());
        investment.setShares(newInvestment.getShares());

        investmentService.addInvestment(newInvestment);


        mockMvc.perform(post("/investments")
                .content(mapper.writeValueAsString(investment))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

                //.andExpect(MockMvcResultMatchers.jsonPath("$.shares").value(investment.getShares()));
    }

}