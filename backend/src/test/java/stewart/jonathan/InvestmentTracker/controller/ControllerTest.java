package stewart.jonathan.InvestmentTracker.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import stewart.jonathan.InvestmentTracker.repository.InvestmentRepository;

@WebMvcTest
public class ControllerTest{

    private final InvestmentRepository investmentRepository;


    public ControllerTest(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }
}
