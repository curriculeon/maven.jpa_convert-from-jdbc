package com.github.curriculeon.dao;

import com.github.curriculeon.model.EntityInterface;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by leon on 8/17/2020.
 */
abstract public class AbstractJpaRepository<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>>
        implements JpaRepositoryInterface<IdType, EntityType> {
    private String persistenceUnitName;
    private EntityManager entityManager;

    public AbstractJpaRepository(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    @Override
    public EntityManager getEntityManager() {
        if(this.entityManager == null) {
            this.entityManager = getEntityManagerFactory().createEntityManager();
        }
        return this.entityManager;
    }

    @Override
    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }
}