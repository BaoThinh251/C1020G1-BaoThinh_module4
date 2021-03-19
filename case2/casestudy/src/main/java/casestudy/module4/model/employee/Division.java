package casestudy.module4.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Integer divisionId;

    @Column(name = "division_name", length = 45)
    private String divisionName;

    public Division() {
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer id) {
        this.divisionId = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String name) {
        this.divisionName = name;
    }
}