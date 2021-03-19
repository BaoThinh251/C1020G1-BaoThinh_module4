package casestudy.module4.model.employee;

import casestudy.module4.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @NotBlank(message = "Must not be blank")
    @Column(name = "employee_name", length = 45, nullable = false)
    private String employeeName;

    @Column(name = "employee_birthday", nullable = false, columnDefinition = "date")
    private String employeeBirthDay;

    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "ID Card must be 9 or 12 character")
    @Column(name = "employee_id_card", nullable = false, length = 45)
    private String idOfEmployee;

    @DecimalMin(value = "0.01", message = "Salary must be positive number")
    @Column(name = "employee_salary", nullable = false)
    private Double employeeSalary;

    @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)",
            message = "Phone number must be (090)-(091)-(+84-90)-(+84-91)")
    @Column(name = "employee_phonenumber", length = 45, nullable = false)
    private String employeePhoneNumber;

    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Email must be abc@abc.abc")
    @Column(name = "employee_email", length = 45, nullable = false)
    private String employeeEmail;

    @NotBlank(message = "Must not be blank")
    @Column(name = "employee_address", length = 45)
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Contract> contracts;

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(String employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public String getIdOfEmployee() {
        return idOfEmployee;
    }

    public void setIdOfEmployee(String idOfEmployee) {
        this.idOfEmployee = idOfEmployee;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
