package com.github.curriculeon.lib.repository;

import com.github.curriculeon.lib.model.EntityInterface;

import java.io.Serializable;

/**
 * Created by leon on 8/17/2020.
 */
public class AutoLoggingRepositoryDecorator<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>>
        implements AutoLoggingRepositoryInterface<IdType, EntityType> {

    private RepositoryInterface<IdType, EntityType> decoratee;

    public AutoLoggingRepositoryDecorator(RepositoryInterface<IdType, EntityType> decoratee) {
        this.decoratee = decoratee;
    }

    @Override
    public RepositoryInterface<IdType, EntityType> getDecoratee() {
        return this.decoratee;
    }
}
