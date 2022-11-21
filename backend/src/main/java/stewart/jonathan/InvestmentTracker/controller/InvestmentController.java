package stewart.jonathan.InvestmentTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stewart.jonathan.InvestmentTracker.model.Investment;
import stewart.jonathan.InvestmentTracker.service.InvestmentService;

import java.util.List;


@RestController
@RequestMapping("investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping("/")
    String welcome(){
        return "Welcome to your online Investment Portfolio Web App";
    }

    @GetMapping
    public List<Investment> getInvestments(){
        return investmentService.getInvestments();
    }

    @GetMapping("/{id}")
    public Investment getInvestmentById(@PathVariable String id){
        return investmentService.getInvestmentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addInvestment(@RequestBody Investment investment){
        investmentService.addInvestment(investment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteInvestment(@PathVariable String id){
        investmentService.deleteInvestment(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateInvestment(@PathVariable String id,
                                 @RequestBody Investment investment) {
        investmentService.updateInvestment(id, investment);
    }
}
