package casestudy.module4.model.customer;

import casestudy.module4.model.contract.Contract;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Code must be KH-XXXX (with X is 0-9)")
    @Column(name = "customer_code")
    private String customerCode;

    @NotBlank(message = "Must not be blank")
    @Column(name = "customer_name", length = 45, nullable = false)
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "date",nullable = false)
    private String customerBirthDay;

    @Column(name = "customer_gender", length = 10, nullable = false)
    private String customerGender;

    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "ID Card must be 9 or 12 character")
    @Column(name = "customer_id_card", length = 45, nullable = false)
    private String idOfCustomer;

    @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)",
            message = "Phone number must be (090)-(091)-(+84-90)-(+84-91)")
    @Column(name = "customer_phone", length = 45, nullable = false)
    private String customerPhoneNumber;

    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Email must be abc@abc.abc")
    @Column(name = "customer_email", length = 45)
    private String customerEmail;

    @NotBlank(message = "Must not be blank")
    @Column(name = "customer_address", length = 45)
    private String customerAddress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Contract> contracts;

    public Customer() {
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int id) {
        this.customerId = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String birthDay) {
        this.customerBirthDay = birthDay;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getIdOfCustomer() {
        return idOfCustomer;
    }

    public void setIdOfCustomer(String customerIdCard) {
        this.idOfCustomer = customerIdCard;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
