package com.phonebook.controler;

import com.phonebook.exception.DataAlreadyExistsException;
import com.phonebook.exception.IncorrectInputException;
import com.phonebook.exception.NoSuchDataException;
import com.phonebook.service.PersonService;
import com.phonebook.service.impl.PersonServiceBook;

import java.util.Scanner;

public class Controler {

    private Scanner data = new Scanner(System.in);
    private PersonService personService  = new PersonServiceBook();

    public String addPerson(String surname,String phoneNumber) {
        try {
            personService.createPerson(surname, phoneNumber);
            return "The record is successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (DataAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    public String showAll() {
        try {
            return personService.showAllPerson();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String showByName(String name) {
        try {
            return personService.showNumberByName(name);
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String showByNumber(String phoneNumber) {
        try {
            return personService.showPersonByNumber(phoneNumber);
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String updatePersonById(String id, String surname, String phoneNumber) {
        try {
            personService.updatePerson(id, surname, phoneNumber);
            return "The update is successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }


    public String deleteById(String id) {
        try {
            personService.deleteById(id);
            return "The delete is successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String findByString(String string){
        try {
            return personService.findByString(string);
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }
}
