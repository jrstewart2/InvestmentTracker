package stewart.jonathan.InvestmentTracker.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table
public class Investment {

    @Id
    private String id;
    private String company;
    private Float shares;

    public Investment() {}

    public Investment(String id, String company, Float shares) {
        this.id = id;
        this.company = company;
        this.shares = shares;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Float getShares() {
        return shares;
    }

    public void setShares(Float shares) {
        this.shares = shares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Investment that = (Investment) o;
        return id.equals(that.id) && company.equals(that.company) && shares.equals(that.shares);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, shares);
    }

    @Override
    public String toString() {
        return "Investment{" +
                "id='" + id + '\'' +
                ", company='" + company + '\'' +
                ", shares=" + shares +
                '}';
    }
}
