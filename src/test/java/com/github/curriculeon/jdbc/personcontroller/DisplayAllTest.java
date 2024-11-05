package com.github.curriculeon.jdbc.personcontroller;

import com.github.curriculeon.lib.DatabaseConnection;
import com.github.curriculeon.lib.config.ConfigurationInterface;
import com.github.curriculeon.lib.config.JdbcConfigurator;
import com.github.curriculeon.api.controllers.PersonController;
import com.github.curriculeon.api.dao.PersonJdbcRepository;
import com.github.curriculeon.api.service.PersonService;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 8/14/2020.
 */
public class DisplayAllTest {
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
        PersonController personController = new PersonController(new PersonService(new PersonJdbcRepository(databaseConnection)));

        // when
        personController.displayAll();

        // then

    }
}