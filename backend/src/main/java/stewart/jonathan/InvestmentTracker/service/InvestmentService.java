package stewart.jonathan.InvestmentTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stewart.jonathan.InvestmentTracker.model.Investment;
import stewart.jonathan.InvestmentTracker.repository.InvestmentRepository;

import java.util.List;


@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository){
        this.investmentRepository = investmentRepository;
    }

    public List<Investment> getInvestments() {
        return investmentRepository.findAll();
    }

    public Investment getInvestmentById(String id){
        return getInvestments().stream()
                .filter(i -> id.equals(i.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Company ticker symbol not found in your portfolio"));
    }

    public void addInvestment(Investment investment) {
        investmentRepository.save(investment);
    }

    public void deleteInvestment(String id) {

        if (investmentRepository.existsById(id)) {
            investmentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("The company " + id + " is not in your investment portfolio");
        }
    }

}
