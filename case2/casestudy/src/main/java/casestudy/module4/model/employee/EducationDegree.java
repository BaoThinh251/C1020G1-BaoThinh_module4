package casestudy.module4.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Integer educationId;

    @Column(name = "education_degree_name", length = 45)
    private String educationName;

    public EducationDegree() {
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer id) {
        this.educationId = id;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String name) {
        this.educationName = name;
    }
}