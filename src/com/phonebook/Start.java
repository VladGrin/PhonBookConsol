package com.phonebook;

import com.phonebook.controler.Controler;
import com.phonebook.exception.IncorrectInputException;

import java.util.Scanner;

public class Start {
    public void start() throws IncorrectInputException {
        int choice = -1;
        Controler controler = new Controler();
        while (true) {
            Scanner read = new Scanner(System.in);
            System.out.print("Make your choice: ");
            System.out.println( "[1]- To add  [2]- Show all  [3]- Show by name  [4]- Show by number  " +
                    "[5]- Update by id  [6]- Delete by id  [0]- Enter");
            String data = read.nextLine();
            try {
                choice = Integer.parseInt(data.trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 0: return;
                case 1: System.out.println(controler.addPerson()); break;
                case 2: System.out.println(controler.showAll()); break;
                case 3: System.out.println(controler.showByName()); break;
                case 4: System.out.println(controler.showByNumber()); break;
                case 5: System.out.println(controler.updatePersonById()); break;
                case 6: System.out.println(controler.deleteById()); break;
                case -1: System.out.println("Incorrectly input"); break;
                default: throw new IncorrectInputException("Incorrectly Input");
            }
            System.out.println("=======================================================");
        }
    }
}
