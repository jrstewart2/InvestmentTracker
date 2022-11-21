package stewart.jonathan.InvestmentTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stewart.jonathan.InvestmentTracker.model.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, String> {
}
