package com.github.curriculeon.lib;


import com.github.curriculeon.lib.utils.PojoToSqlConverter;

import java.io.Serializable;

/**
 * Created by leon on 8/14/2020.
 */
public interface JdbcRepositoryInterface<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>>
        extends RepositoryInterface<IdType, EntityType> {
    DatabaseConnectionInterface getDatabaseConnection();


    default EntityType create(EntityType entity) {
        PojoToSqlConverter pojoToSqlConverter = new PojoToSqlConverter(getDatabaseConnection());
        String insertStatement = pojoToSqlConverter.getInsertStatement(entity);
        getDatabaseConnection().executeStatement(insertStatement);
        return findById(entity.getId()).get();
    }
}
