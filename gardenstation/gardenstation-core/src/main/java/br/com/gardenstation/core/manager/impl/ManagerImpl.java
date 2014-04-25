package br.com.gardenstation.core.manager.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.gardenstation.core.manager.Manager;

public abstract class ManagerImpl<T, I extends Serializable> implements Manager<T, I> {
    
    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> persistenceClass;

    protected abstract Class<T> informPersistenceClass();

    public ManagerImpl() {
        this.persistenceClass = this.informPersistenceClass();
    }
    
    @Transactional
    public T persist(T entity) {
        this.beforePersisting(entity);
        this.entityManager.persist(entity);
        this.afterPersisting(entity);
        return entity;
    }

    @Transactional
    public T save(T entity) {
        if (this.entityManager.contains(entity)) {
            return this.merge(entity);
        }
        return this.persist(entity);
    }

    @Transactional
    public T merge(T entity) {
        this.beforeMerging(entity);
        T mergedEntity = this.entityManager.merge(entity);
        this.afterMerging(mergedEntity);
        return mergedEntity;
    }

    @Transactional
    public void remove(T entity) {
        this.beforeRemoving(entity);
        this.entityManager.remove(entity);
        this.afterRemoving(entity);
    }
    
    @Transactional
    public T findById(I id) {
        T entity = this.entityManager.find(this.getPersistenceClass(), id);
        if (entity != null) {
            this.entityManager.refresh(entity);
        }
        return entity;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getPersistenceClass() {
        return this.persistenceClass;
    }

    public void setPersistenceClass(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass;
    }
    
    private void beforePersisting(T entity) { }

    private void beforeMerging(T entity) { }

    private void beforeRemoving(T entity) { }

    private void afterPersisting(T entity) { }

    private void afterMerging(T entity) { }

    private void afterRemoving(T entity) { }
}
