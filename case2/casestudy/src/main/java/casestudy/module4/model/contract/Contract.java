package casestudy.module4.model.contract;

import casestudy.module4.model.contract.ContractDetail;
import casestudy.module4.model.customer.Customer;
import casestudy.module4.model.employee.Employee;
import casestudy.module4.model.services.Services;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer id;

    @NotNull
    @Column(name = "contract_start_date", nullable = false, columnDefinition = "date")
    private String startDate;

    @NotNull
    @Column(name = "contract_end_date", nullable = false, columnDefinition = "date")
    private String endDate;

    @NotNull
    @DecimalMin(value = "0.01", message = "Deposit must be positive")
    @Column(name = "contract_deposit", nullable = false)
    private Double deposit;

    @NotNull
    @DecimalMin(value = "0.01", message = "Total must be positive")
    @Column(name = "contract_total_money", nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false)
    private Services service;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract")
    private List<ContractDetail> contractDetails;

    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
