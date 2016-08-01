package com.endava.training.model;

import javax.persistence.*;

/**
 * Created by iciuta on 7/26/2016.
 */
@Entity
@Table(name = "project")
public class Project extends AbstractEntity {
    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_manager")
    private Employee manager;

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project: " + name + "\n" + "Description: " + description + "\n" + manager;
    }
}
