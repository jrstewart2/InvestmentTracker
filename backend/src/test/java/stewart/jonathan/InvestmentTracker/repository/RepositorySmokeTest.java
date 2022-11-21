package stewart.jonathan.InvestmentTracker.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RepositorySmokeTest {

    @Autowired
    private InvestmentRepository repo;

    @Test
    public void contextLoads() throws Exception {
        assertThat(repo).isNotNull();
    }
}
