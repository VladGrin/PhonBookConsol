package com.phonebook.controler;

import com.phonebook.exception.IncorrectInputException;
import com.phonebook.model.Person;
import com.phonebook.service.impl.PersonServiceBook;
import com.phonebook.validator.Validator;

import java.util.Scanner;

public class Controler {

    private Scanner data = new Scanner(System.in);
    private PersonServiceBook book = new PersonServiceBook();

    public boolean addPerson() {
        String name = null;
        String phoneNumber = null;
        try {
            System.out.print("Input surname : ");
            Validator.nameSurnameValidation(name = data.nextLine());
            System.out.print("Input phone number : ");
            Validator.phoneNumberValidation(phoneNumber = data.nextLine());
        } catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return book.createPerson(new Person(name, phoneNumber));
    }

    public String showAll() {
        return book.showAllPerson();
    }

    public String showByName() {
        String name = null;
        try {
            System.out.print("Input surname : ");
            Validator.nameSurnameValidation(name = data.nextLine());
        } catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
            return "Wrong name";
        }
        return book.showNumberByName(name);
    }

    public String showByNumber() {
        String phoneNumber = null;
        try {
            System.out.print("Input phone number : ");
            Validator.phoneNumberValidation(phoneNumber = data.nextLine());
        } catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
            return "Wrong phone number";
        }
        return book.showPersonByNumber(phoneNumber);
    }

    public boolean updatePersonById() {
        String surame = null, phoneNumber = null, idString = null;
        int id;
        try {
            System.out.print("Input id : ");
            Validator.idValidation(idString = data.nextLine());
            System.out.print("Input new surname : ");
            surame = data.nextLine();
            System.out.print("Input new phone numberv: ");
            phoneNumber = data.nextLine();
        } catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return book.updatePerson(new Person(Integer.parseInt(idString), surame, phoneNumber));
    }


    public boolean deleteById() {
        String idString = null;
        try {
            System.out.print("Input id : ");
            Validator.idValidation(idString = data.nextLine());
        }catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return book.deleteById(Integer.parseInt(idString));
    }
}
