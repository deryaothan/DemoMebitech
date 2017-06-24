package mebitechDemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * @author Derya Othan
 * @version 0.0.1
 */

@Entity
@Table(name = "EMPLOYEE")
public class Meetings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id", insertable = false)
    private Department department;

    public Meetings() {

    }

    public Meetings(long id) {
        this.id = id;
    }

    public Meetings(String name, String description, Department department) {
        this.name = name;
        this.description = description;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
