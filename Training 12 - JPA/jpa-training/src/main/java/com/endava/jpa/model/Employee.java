package com.endava.jpa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by iciuta on 7/26/2016.
 */
@Entity
@Table(name = "employee")
public class Employee extends AbstractEntity {
    @Column
    private String name;

    @Column
    private String salary;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Column(name = "zip_code")
    private String zipcode;

    @Column(nullable = false)
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee:\n " + name + ", " + birthday + ", " + salary + "\n" +
                "Address: " + street + " " + city + " " + state + " " + zipcode + "\n" +
                (department == null ? "NO DEPT." : department.toString());

    }
}
