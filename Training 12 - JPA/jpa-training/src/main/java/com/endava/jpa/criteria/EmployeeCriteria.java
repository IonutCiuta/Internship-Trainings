package com.endava.jpa.criteria;

import com.endava.jpa.model.Department;

/**
 * Created by iciuta on 7/27/2016.
 */
public class EmployeeCriteria {
    private String city;
    private Department department;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
