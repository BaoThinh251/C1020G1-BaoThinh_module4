package casestudy.module4.model.employee;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String employeeName;

    private String employeeBirthDay;

    private String idOfEmployee;

    private double employeeSalary;

    private String employeePhoneNumber;

    private String employeeEmail;

    private String employeeAddress;

    private int positionId;

    private int eduDegreeId;

    private int divisonId;

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
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

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
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

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getEduDegreeId() {
        return eduDegreeId;
    }

    public void setEduDegreeId(int eduDegreeId) {
        this.eduDegreeId = eduDegreeId;
    }

    public int getDivisonId() {
        return divisonId;
    }

    public void setDivisonId(int divisonId) {
        this.divisonId = divisonId;
    }
}
