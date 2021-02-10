package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import edu.uark.registerapp.models.entities.EmployeeEntity;
import org.apache.commons.lang3.StringUtils;

import edu.uark.registerapp.models.api.Role;

public class Employee extends ApiResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private UUID employeeId;
    private boolean active;
    private Role classification;
    private Employee manager;

    // I don't know if we're gonna be allowed to just use a string for this
    private String password;
    private String createdOn;


    public UUID getId() {
        return id;
    }

    public Employee setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public Employee setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Employee setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Role getClassification() {
        return classification;
    }

    public Employee setClassification(Role classification) {
        this.classification = classification;
        return this;
    }

    public Employee getManager() {
        return manager;
    }

    public Employee setManager(Employee manager) {
        this.manager = manager;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public Employee setCreatedOn(final LocalDateTime createdOn) {
        this.createdOn =
                createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return this;
    }


    public Employee() {
        super();

        this.id = new UUID(0, 0);
        this.firstName = StringUtils.EMPTY;
        this.lastName = StringUtils.EMPTY;
        this.employeeId = new UUID(0, 0);
        this.active = false;
        this.classification = Role.CASHIER;

        // Not how the default is generated in the database?
        this.manager = null;
        this.password = StringUtils.EMPTY;
        this.setCreatedOn(LocalDateTime.now());
    }

    public Employee(final EmployeeEntity employeeEntity) {
        super(false);

        this.id = employeeEntity.getId();
        this.firstName = employeeEntity.getFirstName();
        this.lastName = employeeEntity.getLastName();
        this.employeeId = employeeEntity.getEmployeeId();
        this.active = employeeEntity.isActive();
        this.classification = employeeEntity.getClassification();

        // Not how the default is generated in the database?
        this.manager = employeeEntity.getManager();
        this.password = employeeEntity.getPassword();
        this.setCreatedOn(employeeEntity.getCreatedOn());
    }

}
