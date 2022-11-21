package stewart.jonathan.InvestmentTracker.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stewart.jonathan.InvestmentTracker.model.Investment;
import stewart.jonathan.InvestmentTracker.repository.InvestmentRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ServiceUnitTest {

    @Mock
    InvestmentRepository repo;

    @InjectMocks
    InvestmentService service;

    @Test
    public void should_return_code_ok_when_investment_added() {
        Investment investment = new Investment();
        investment.setId("TEST");
        investment.setCompany("Testing company");
        investment.setShares(123F);

        service.addInvestment(investment);
        assertThat(service.getInvestmentById(investment.getId()).getCompany().equals(investment.getCompany()));
    }


}
