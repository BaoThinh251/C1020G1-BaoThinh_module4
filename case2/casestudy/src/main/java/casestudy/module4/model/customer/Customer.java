package casestudy.module4.model.customer;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @Column(name = "customer_name", length = 45, nullable = false)
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "date",nullable = false)
    private String customerBirthDay;

    @Column(name = "customer_gender", length = 10, nullable = false)
    private String customerGender;

    @Column(name = "customer_id_card", length = 45, nullable = false)
    private String idOfCustomer;

    @Column(name = "customer_phone", length = 45, nullable = false)
    private String customerPhoneNumber;

    @Column(name = "customer_email", length = 45)
    private String customerEmail;

    @Column(name = "customer_address", length = 45)
    private String customerAddress;

    public Customer() {
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int id) {
        this.customerId = id;
    }

    public CustomerType getIdType() {
        return customerType;
    }

    public void setIdType(CustomerType customerType) {
        this.customerType = customerType;
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
