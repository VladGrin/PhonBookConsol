package com.phonebook.service;

import com.phonebook.exception.DataAlreadyExistsException;
import com.phonebook.exception.IncorrectInputException;
import com.phonebook.exception.NoSuchDataException;
import com.phonebook.model.Person;

public interface PersonService {
    boolean createPerson(String surname,String phoneNumber) throws IncorrectInputException, DataAlreadyExistsException;
    String showAllPerson() throws NoSuchDataException;
    String showNumberByName(String name) throws IncorrectInputException, NoSuchDataException;
    String showPersonByNumber(String number) throws NoSuchDataException, IncorrectInputException;
    boolean updatePerson(String id, String surname, String phoneNumber) throws IncorrectInputException, NoSuchDataException;
    boolean deleteById(String id) throws IncorrectInputException, NoSuchDataException;
    String findByString(String string) throws IncorrectInputException, NoSuchDataException;
}
