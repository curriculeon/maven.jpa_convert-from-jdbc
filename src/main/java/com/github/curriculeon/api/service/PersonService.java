package com.github.curriculeon.api.service;

import com.github.curriculeon.lib.repository.RepositoryInterface;
import com.github.curriculeon.api.Person;
import com.github.curriculeon.lib.service.AbstractService;

/**
 * Created by leon on 8/13/2020.
 */ // TODO - extend AbstractService<Long, Person, PersonRepository>
public class PersonService extends AbstractService<Long, Person, RepositoryInterface<Long, Person>> {
    public PersonService(RepositoryInterface<Long, Person> repository) {
        super(repository);
    }
}
