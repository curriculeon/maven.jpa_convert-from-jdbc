package com.github.curriculeon.api.dao;

import com.github.curriculeon.api.model.Person;
import com.github.curriculeon.api.model.PersonBuilder;
import com.github.curriculeon.lib.repository.AbstractJpaRepository;

/**
 * Created by leon on 8/17/2020.
 */
public class PersonJpaRepository extends AbstractJpaRepository<Long, Person> {
    public PersonJpaRepository(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public Person update(Person dataToBeUpdated, Person newEntityData) {
        return new PersonBuilder(dataToBeUpdated)
                .setEmail(newEntityData.getEmail())
                .setName(newEntityData.getName())
                .setPassword(newEntityData.getPassword())
                .build();
    }
}
