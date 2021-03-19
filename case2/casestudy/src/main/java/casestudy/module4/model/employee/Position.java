package casestudy.module4.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "position_name", length = 45)
    private String positionName;

    public Position() {
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer id) {
        this.positionId = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String name) {
        this.positionName = name;
    }
}
