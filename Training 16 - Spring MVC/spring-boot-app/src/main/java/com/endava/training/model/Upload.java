package com.endava.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by iciuta on 8/1/2016.
 */
@Entity
@Table(name = "upload")
public class Upload extends AbstractEntity{
    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private String path;

    @Column
    private Integer size;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
