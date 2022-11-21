package stewart.jonathan.InvestmentTracker.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ServiceSmokeTest {

    @Autowired
    private InvestmentService service;

    @Test
    public void contextLoads() throws Exception {
        assertThat(service).isNotNull();
    }
}
