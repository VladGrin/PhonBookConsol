package com.phonebook;

import com.phonebook.controler.Controler;
import com.phonebook.exception.IncorrectInputException;

import java.util.Scanner;

public class Start {

    private Scanner read = new Scanner(System.in);
    private Controler controler = new Controler();

    public void start() throws IncorrectInputException {
        int choice = -1;
        while (true) {
            System.out.print("Make your choice: ");
            System.out.println("[1]- To add  [2]- Show all  [3]- Show by name  [4]- Show by number  " +
                    "[5]- Update by id  [6]- Delete by id   [7]- Find  [0]- Enter");
            String data = read.nextLine();
            try {
                choice = Integer.parseInt(data.trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println(addPerson());
                    break;
                case 2:
                    System.out.println(showAll());
                    break;
                case 3:
                    System.out.println(showByName());
                    break;
                case 4:
                    System.out.println(showByNumber());
                    break;
                case 5:
                    System.out.println(updatePersonById());
                    break;
                case 6:
                    System.out.println(deleteById());
                    break;
                case 7:
                    System.out.println(findByString());
                    break;
                case -1:
                    System.out.println("Incorrectly input");
                    break;
                default:
                    throw new IncorrectInputException("Incorrectly Input");
            }
            System.out.println("=======================================================");
        }
    }

    private String addPerson() {
        System.out.print("Input surname : ");
        String surname = read.nextLine();
        System.out.print("Input phone number : ");
        String phoneNumber = read.nextLine();
        return controler.addPerson(surname, phoneNumber);
    }

    private String showAll() {
        return controler.showAll();
    }

    private String showByName() {
        System.out.print("Input surname : ");
        String name = read.nextLine();
        return controler.showByName(name);
    }

    private String showByNumber() {
        System.out.print("Input phone number : ");
        String phoneNumber = read.nextLine();
        return controler.showByNumber(phoneNumber);
    }

    private String updatePersonById() {
        System.out.print("Input id : ");
        String id = read.nextLine();
        System.out.print("Input new surname : ");
        String surname = read.nextLine();
        System.out.print("Input new phone number: ");
        String phoneNumber = read.nextLine();
        return controler.updatePersonById(id, surname, phoneNumber);
    }

    private String deleteById() {
        System.out.print("Input id : ");
        String id = read.nextLine();
        return controler.deleteById(id);
    }

    private String findByString() {
        System.out.print("Input letters : ");
        String string = read.nextLine();
        return controler.findByString(string);
    }
}

