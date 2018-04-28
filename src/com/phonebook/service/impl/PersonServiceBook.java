package com.phonebook.service.impl;

import com.phonebook.exception.IncorrectInputException;
import com.phonebook.filehandling.fileHandling;
import com.phonebook.model.Person;
import com.phonebook.repository.PersonRepository;
import com.phonebook.repository.impl.PersonRepositoryMap;
import com.phonebook.validator.Validator;

import java.util.Scanner;

public class PersonServiceBook {

    private static PersonRepository book = new PersonRepositoryMap();

    public static void dataInit(){
        book = fileHandling.readFromFile();
    }

    public static void start()throws IncorrectInputException {
        char choice;
        dataInit();
        while (true){
            Scanner read = new Scanner(System.in);
            System.out.println("");
            System.out.println("Make your choice");
            System.out.println("To add a subscriber, press '1'");
            System.out.println("To search for a number by surname, press '2'");
            System.out.println("To search for a person by number, press '3'");
            System.out.println("Press '0' to enter");
            String data = read.nextLine();
            choice = data.charAt(0);
            if (choice != '0' && choice != '1' && choice != '2' && choice != '3')
                throw new IncorrectInputException("Incorrectly Input");
            if (choice == '0') break;
            if (choice == '1') inputData();
            if (choice == '2') outputPhoneNumber();
            if (choice == '3') outputSurname();
            System.out.println("");
        }
    }

    private static void inputData() throws IncorrectInputException {
        Scanner read = new Scanner(System.in);
        System.out.print("Input surname : ");
        String data = read.nextLine();
        if ( !Validator.nameSurnameValidation(data) )
            throw new IncorrectInputException("Error input data");
        String surname = data;
        System.out.print("Input phone number : ");
        data = read.nextLine();
        if ( !Validator.phoneNumberValidation(data) )
            throw new IncorrectInputException("Error input data");
        String phoneNumber = data;
        Person person = new Person(surname, phoneNumber);
        fileHandling.writeToFile(person);
        System.out.println(book.create(person));
    }

    private static void outputPhoneNumber() throws IncorrectInputException {
        Scanner read = new Scanner(System.in);
        System.out.print("Input surname : ");
        String data = read.nextLine();
        if ( !Validator.nameSurnameValidation(data) )
            throw new IncorrectInputException("Error input data");
        String phoneNumber = book.outputPhoneNumber(data);
        System.out.println(data + " : " + phoneNumber);
    }

    private static void outputSurname() throws IncorrectInputException {
        Scanner read = new Scanner(System.in);
        System.out.print("Input phone number : ");
        String data = read.nextLine();
        if ( !Validator.phoneNumberValidation(data) )
            throw new IncorrectInputException("Error input data");
        String surname = book.outputSurname(data);
        System.out.println(data + " : " + surname);
    }
}
