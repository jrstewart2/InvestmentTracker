package stewart.jonathan.InvestmentTracker.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(InvestmentController.class)
public class ControllerTest{

    @Autowired
    MockMvc mockMvc;

//    @MockBean
//    public InvestmentController controller;

    @Test
    void homeTest() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/investments/"))
                .andExpect(status().isOk())
                // cannt get andExpect(content()... to work
                .andDo(print());
    }

    @Test
    public void getInvestmentsAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/investments")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.investments").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.investments[*].id").isNotEmpty());
    }

    @Test
    public void getInvestmentByIdAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/investments/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.investmentsId").value(1));
    }


}
