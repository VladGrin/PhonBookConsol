package com.phonebook.service.impl;

import com.phonebook.model.Person;
import com.phonebook.repository.PersonRepository;
import com.phonebook.repository.impl.PersonRepositoryImpl;
import com.phonebook.repository.impl.PersonRepositoryMap;
import com.phonebook.service.PersonService;

public class PersonServiceBook implements PersonService {

    PersonRepository personRepository = new PersonRepositoryImpl();//new PersonRepositoryMap();

    @Override
    public boolean createPerson(Person person) {
        return personRepository.createPerson(person);
    }

    @Override
    public String showAllPerson() {
        return personRepository.showAllPerson();
    }

    @Override
    public String showNumberByName(String name) {
        return personRepository.showNumberByName(name);
    }

    @Override
    public String showPersonByNumber(String number) {
        return personRepository.showPersonByNumber(number);
    }

    @Override
    public boolean updatePerson(Person person) {
        return personRepository.updatePerson(person);
    }

    @Override
    public boolean deleteById(int id) {
        return personRepository.deleteById(id);
    }
}
