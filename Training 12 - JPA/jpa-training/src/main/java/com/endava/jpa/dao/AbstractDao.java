package com.endava.jpa.dao;

import com.endava.jpa.model.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Created by iciuta on 7/26/2016.
 */
public abstract class AbstractDao<E extends AbstractEntity> implements Dao<E, Long> {
    @PersistenceContext
    protected EntityManager entityManager;

    private Class<E> clazz;

    public E find(Long id) {
        return entityManager.find(getType(), id);
    }

    public void save(E toBeSaved) {
        entityManager.merge(toBeSaved);
    }

    public void update(E toBeUpdated) {
        entityManager.merge(toBeUpdated);
    }

    public void delete(E toBeRemoved) {
        entityManager.remove(entityManager.contains(toBeRemoved) ? toBeRemoved : entityManager.merge(toBeRemoved));
    }

    /* Used to access and lazily initialize the clazz parameter*/
    @SuppressWarnings("unchecked")
    private Class<E> getType() {
        if(this.clazz == null) {
            ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
            this.clazz = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
        }

        return this.clazz;
    }
}
