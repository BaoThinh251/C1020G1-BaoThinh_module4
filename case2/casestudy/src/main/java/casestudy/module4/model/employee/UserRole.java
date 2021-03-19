//package casestudy.module4.model.employee;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "user_role")
//public class UserRole implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_role_id")
//    private Integer userRoleId;
//
//    @ManyToOne
//    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
//    private User User;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
//    private Role Role;
//
//    public UserRole() {
//    }
//
//    public UserRole(User User, Role Role) {
//        this.User = User;
//        this.Role = Role;
//    }
//
//    public User getUser() {
//        return User;
//    }
//
//    public void setUser(User User) {
//        this.User = User;
//    }
//
//    public Role getRole() {
//        return Role;
//    }
//
//    public void setRole(Role Role) {
//        this.Role = Role;
//    }
//}
