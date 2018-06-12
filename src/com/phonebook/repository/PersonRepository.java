package com.phonebook.repository;

import com.phonebook.model.Person;

public interface PersonRepository {

    boolean createPerson(Person person);
    String showAllPerson();
    String showNumberByName(String name);
    String showPersonByNumber(String number);
    boolean updatePerson(Person person);
    boolean deleteById(String id);
    String findByString(String string);
}
