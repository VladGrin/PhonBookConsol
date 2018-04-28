package com.phonebook.repository;

import com.phonebook.model.Person;

public interface PersonRepository {

    boolean create(Person person);
    String outputPhoneNumber(String string);
    String outputSurname(String string);


    Person read(int id);
    boolean update(Person person);
    boolean delete(int id);
    boolean delete(Person person);
}
