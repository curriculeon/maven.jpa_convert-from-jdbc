package com.github.curriculeon.lib;

import java.io.Serializable;

/**
 * Created by leon on 8/18/2020.
 */ // TODO
public enum PersistenceUnit {
    PRODUCTION;

    public <
            IdType extends Serializable,
            EntityType extends EntityInterface<IdType>,
            RepositoryType extends RepositoryInterface<IdType, EntityType>>
    void perform(RepositoryType repository) {

    }
}
