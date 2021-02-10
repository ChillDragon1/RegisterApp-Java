package edu.uark.registerapp.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.uark.registerapp.models.api.Employee;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import edu.uark.registerapp.models.api.Role;


@Entity
@Table(name="employee")
public class EmployeeEntity {
    @Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

    public UUID getId() {
        return this.id;
    }

    @Column(name = "employeeid")
    private UUID employeeId;

    public UUID getEmployeeId() {
        return this.employeeId;
    }

    public EmployeeEntity setEmployeeId(final UUID employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    @Column(name = "firstname")
    private String firstName;

    public String getFirstName() {
        return this.firstName;
    }

    public EmployeeEntity setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "lastname")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public EmployeeEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(name = "active")
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public EmployeeEntity setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Column(name = "classification")
    private Role classification;
    public Role getClassification() {
        return classification;
    }

    public EmployeeEntity setClassification(Role classification) {
        this.classification = classification;
        return this;
    }

    @Column(name = "managerid")
    private Employee manager;
    public Employee getManager() {
        return manager;
    }

    public EmployeeEntity setManager(Employee manager) {
        this.manager = manager;
        return this;
    }

    @Column(name = "password")
    private String password;
    public String getPassword() {
        return password;
    }

    public EmployeeEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(name = "createdon")
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdOn;
    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public Employee synchronize(final Employee apiEmployee) {


        this.setFirstName(apiEmployee.getFirstName());
        this.setLastName(apiEmployee.getLastName());
        this.setEmployeeId(apiEmployee.getEmployeeId());
        this.setActive(apiEmployee.isActive());
        this.setClassification(apiEmployee.getClassification());
        this.setManager(apiEmployee.getManager());
        this.setPassword(apiEmployee.getPassword());

        apiEmployee.setId(this.getId());
        apiEmployee.setCreatedOn(this.getCreatedOn());

        return apiEmployee;
    }

    public EmployeeEntity() {
        this.id = new UUID(0, 0);
        this.firstName = StringUtils.EMPTY;
        this.lastName = StringUtils.EMPTY;
        this.employeeId = new UUID(0, 0);
        this.active = false;
        this.classification = Role.CASHIER;

        this.manager = null;
        this.password = StringUtils.EMPTY;
    }

    public EmployeeEntity(final Employee apiEmployee) {
        this.id = apiEmployee.getId();
        this.firstName = apiEmployee.getFirstName();
        this.lastName = apiEmployee.getLastName();
        this.employeeId = apiEmployee.getEmployeeId();
        this.active = apiEmployee.isActive();
        this.classification = apiEmployee.getClassification();

        this.manager = apiEmployee.getManager();
        this.password = apiEmployee.getPassword();
    }

}
