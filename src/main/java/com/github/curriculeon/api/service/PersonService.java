package com.github.curriculeon.api.service;

import com.github.curriculeon.lib.RepositoryInterface;
import com.github.curriculeon.api.Person;
import com.github.curriculeon.lib.AbstractService;

/**
 * Created by leon on 8/13/2020.
 */ // TODO - extend AbstractService<Long, Person, PersonRepository>
public class PersonService extends AbstractService<Long, Person, RepositoryInterface<Long, Person>> {
    public PersonService(RepositoryInterface<Long, Person> repository) {
        super(repository);
    }
}
