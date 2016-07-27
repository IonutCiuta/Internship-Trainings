package com.endava.jpa.dao;

import com.endava.jpa.model.AbstractEntity;

import java.util.List;

/**
 * Created by iciuta on 7/26/2016.
 */
public interface Dao<E extends AbstractEntity, PK> {
    List<E> findAll();
    E find(PK id);
    void save(E toBeSaved);
    void update(E toBeUpdated);
    void delete(E toBeRemoved);
}
