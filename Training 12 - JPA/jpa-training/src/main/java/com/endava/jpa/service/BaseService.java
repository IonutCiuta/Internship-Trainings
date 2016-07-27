package com.endava.jpa.service;

import com.endava.jpa.model.AbstractEntity;

/**
 * Created by iciuta on 7/26/2016.
 */
public interface BaseService<E extends AbstractEntity, PK> {
    E find(PK id);

   void save(E toBeSaved);

   void update(E toBeUpdated);

   void delete(E toBeRemoved);
}
