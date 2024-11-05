package com.github.curriculeon.jpa.personrepository;

import com.github.curriculeon.lib.connection.DatabaseConnection;
import com.github.curriculeon.lib.config.JpaConfigurator;
import com.github.curriculeon.api.dao.PersonJpaRepository;
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

    @Before
    public void setup() {
        // given
        DatabaseConnection.TESTING_DATABASE.drop(); // TODO - configure in `persistence.xml`
        DatabaseConnection.TESTING_DATABASE.create(); // TODO - configure in `persistence.xml`
        JpaConfigurator configurator = new JpaConfigurator("testing");
        configurator.appendSqlScript("testing.person_create-table.sql");
        configurator.appendSqlScript("testing.person_populate-table.sql");
        configurator.initialize();
    }

    @Test
    public void test() {
        // given
        RepositoryInterface<Long, Person> repository = new PersonJpaRepository("testing");

        // when
        List<Person> personList = repository.findAll();

        // then
        Assert.assertFalse(personList.isEmpty());
    }
}
