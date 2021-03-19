//package casestudy.module4.model.employee;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user")
//public class User {
//    @Id
//    @Column(name = "username", nullable = false)
//    private String username;
//
//    @Column(name = "password", nullable = false)
//    private String password;
//
//    @OneToOne
//    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
//    private Employee employee;
//
//    public User() {
//    }
//
//    public User(String email, Employee employee) {
//        this.username = email;
//        this.password = "b4othinh";
//        this.employee = employee;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//}
