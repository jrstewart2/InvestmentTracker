package stewart.jonathan.InvestmentTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import stewart.jonathan.InvestmentTracker.model.Investment;
import stewart.jonathan.InvestmentTracker.repository.InvestmentRepository;

import java.util.List;

@Configuration
public class InvestmentConfig {

    @Bean
    CommandLineRunner commandLineRunner(InvestmentRepository investmentRepository) {
        return args -> {
            Investment tesla = new Investment(
                    "TSLA",
                    "Tesla",
                    10.0f
            );
            Investment apple = new Investment(
                    "AAPL",
                    "Apple",
                    7.0f
            );
            Investment google = new Investment(
                    "GOOGL",
                    "Google (Alphabet)",
                    12.0f
            );
            Investment microsoft = new Investment(
                    "MSFT",
                    "Microsoft",
                    1.0f
            );
            investmentRepository.saveAll(List.of(tesla, apple, google, microsoft));
        };
    }
}
