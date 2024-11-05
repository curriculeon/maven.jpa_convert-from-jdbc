package com.github.curriculeon.lib;

import java.io.Serializable;

/**
 * Created by leon on 8/14/2020.
 */
public abstract class AbstractJdbcRepository<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>>
        implements JdbcRepositoryInterface<IdType, EntityType> {

    private DatabaseConnectionInterface databaseConnection;

    public AbstractJdbcRepository(DatabaseConnectionInterface databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public DatabaseConnectionInterface getDatabaseConnection() {
        return this.databaseConnection;
    }
}
