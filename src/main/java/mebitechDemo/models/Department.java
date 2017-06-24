package mebitechDemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Derya Othan
 * @version 0.0.1
 */

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String emp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false)
    private Employee employee;

    public Department() {

    }

    public Department(long id) {
        this.id = id;
    }

    public Department(String name, Employee employee, String description) {
        this.description=description;
        this.employee=employee;
        this.name=name;
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

    public String getEmployee() {
        return emp;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
