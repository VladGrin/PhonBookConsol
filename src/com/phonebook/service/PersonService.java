package com.phonebook.service;

import com.phonebook.model.Person;

public interface PersonService {
    boolean createPerson(Person person);
    String showAllPerson();
    String showNumberByName(String name);
    String showPersonByNumber(String number);
    boolean updatePerson(Person person);
    boolean deleteById(int id);
}
