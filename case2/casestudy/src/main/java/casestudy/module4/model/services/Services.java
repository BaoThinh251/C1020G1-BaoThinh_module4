package casestudy.module4.model.services;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "service")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;

    @Pattern(regexp = "^(DV-)\\d{4}$", message = "Code must be DV-XXXX (with X is 0-9)")
    @Column(name = "service_code")
    private String serviceCode;

    @NotBlank(message = "Must not be blank")
    @Column(name = "service_name")
    private String serviceName;

    @DecimalMin(value = "0.01", message = "Area must be positive number")
    @Column(name = "service_area")
    private double serviceArea;

    @DecimalMin(value = "0.01", message = "Cost must be positive number")
    @Column(name = "service_cost")
    private double serviceCost;

    @DecimalMin(value = "0.01", message = "Max people must be positive number")
    @Column(name = "max_people")
    private int maxPeople;

    @NotBlank(message = "Must not be blank")
    @Column(name = "room_type")
    private String roomType;

    @NotBlank(message = "Must not be blank")
    @Column(name = "other_description")
    private String otherDescription;

    @DecimalMin(value = "0.01", message = "Pool area must be positive number")
    @Column(name = "pool_area")
    private double poolArea;

    @DecimalMin(value = "0.01", message = "Floor must be positive number")
    @Column(name = "floor")
    private int floor;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id", nullable = false)
    private ServiceType serviceType;

    public Services() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
