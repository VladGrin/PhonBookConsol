package com.phonebook.service.impl;

import com.phonebook.exception.DataAlreadyExistsException;
import com.phonebook.exception.IncorrectInputException;
import com.phonebook.exception.NoSuchDataException;
import com.phonebook.model.Person;
import com.phonebook.repository.PersonRepository;
import com.phonebook.repository.impl.PersonRepositoryImpl;
import com.phonebook.service.PersonService;
import com.phonebook.validator.Validator;

import java.security.SecureRandom;


public class PersonServiceBook implements PersonService {

    PersonRepository personRepository = new PersonRepositoryImpl();//new PersonRepositoryMap();

    @Override
    public boolean createPerson(String surname, String phoneNumber) throws IncorrectInputException, DataAlreadyExistsException {
        Validator.validateText(surname);
        Validator.validatePhoneNumber(phoneNumber);

        if (!personRepository.createPerson(new Person.Builder().setSurname(surname).setPhoneNumber(phoneNumber).build())) {
            throw new DataAlreadyExistsException("Such data already exists");
        }
        return true;
    }

    @Override
    public String showAllPerson() throws NoSuchDataException {
        String string = personRepository.showAllPerson();
        if (string == null)
            throw new NoSuchDataException("There is no such data");
        return string;
    }

    @Override
    public String showNumberByName(String name) throws IncorrectInputException, NoSuchDataException {
        Validator.validateText(name);
        String string = personRepository.showNumberByName(name);
        if (string == null)
            throw new NoSuchDataException("There is no such data");
        return string;
    }

    @Override
    public String showPersonByNumber(String number) throws NoSuchDataException, IncorrectInputException {
        Validator.validatePhoneNumber(number);
        String string = personRepository.showPersonByNumber(number);
        if (string == null)
            throw new NoSuchDataException("There is no such data");
        return string;
    }

    @Override
    public boolean updatePerson(String id, String surname, String phoneNumber) throws IncorrectInputException, NoSuchDataException {
        Validator.validateNumber(id);
        Validator.validateText(surname);
        Validator.validatePhoneNumber(phoneNumber);

        if (!personRepository.updatePerson(new Person.Builder().setId(id).setSurname(surname).setPhoneNumber(phoneNumber).build()))
            throw new NoSuchDataException("There is no such data");
        return true;
    }

    @Override
    public boolean deleteById(String id) throws IncorrectInputException, NoSuchDataException {
        Validator.validateNumber(id);

        if (!personRepository.deleteById(id))
            throw new NoSuchDataException("There is no such data");
        return true;
    }

    @Override
    public String findByString(String string) throws IncorrectInputException, NoSuchDataException {
        String strings = personRepository.findByString(string);
        if (strings == null)
            throw new NoSuchDataException("There is no such data");
        return strings;
    }
}
