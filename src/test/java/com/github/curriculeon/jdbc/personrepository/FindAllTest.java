package com.github.curriculeon.jdbc.personrepository;

import com.github.curriculeon.lib.connection.DatabaseConnection;
import com.github.curriculeon.lib.config.ConfigurationInterface;
import com.github.curriculeon.lib.config.JdbcConfigurator;
import com.github.curriculeon.api.dao.PersonJdbcRepository;
import com.github.curriculeon.lib.repository.RepositoryInterface;
import com.github.curriculeon.api.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by leon on 8/14/2020.
 */
public class FindAllTest {
    private DatabaseConnection databaseConnection;

    @Before
    public void setup() {
        // given
        this.databaseConnection = DatabaseConnection.TESTING_DATABASE;
        databaseConnection.drop();
        databaseConnection.create();
        databaseConnection.use();
        ConfigurationInterface configurator = new JdbcConfigurator(databaseConnection);
        configurator.appendSqlScript("testing.person_create-table.sql");
        configurator.appendSqlScript("testing.person_populate-table.sql");
        configurator.initialize();
    }

    @Test
    public void test() {
        // given
        RepositoryInterface<Long, Person> repository = new PersonJdbcRepository(databaseConnection);

        // when
        List<Person> personList = repository.findAll();

        // then
        Assert.assertFalse(personList.isEmpty());
    }
}
