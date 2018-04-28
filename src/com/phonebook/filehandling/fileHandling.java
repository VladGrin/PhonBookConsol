package com.phonebook.filehandling;

import com.phonebook.model.Person;
import com.phonebook.repository.PersonRepository;
import com.phonebook.repository.impl.PersonRepositoryMap;
import com.phonebook.service.impl.PersonServiceBook;

import java.io.*;

public class fileHandling {

    public static PersonRepository readFromFile(){
        BufferedReader br = null;
        PersonRepository book = new PersonRepositoryMap();

        try {
            br = new BufferedReader(new FileReader("datafile.txt"));
            String line;
            String[] temp = new String[2];
            while ( (line = br.readLine()) != null) {
                temp = line.split(" ");
                book.create(new Person(temp[0], temp[1]));
            }
        }catch (IOException e) {
            System.out.println("Error " + e);
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

    public static void writeToFile(Person person) {
        try {

            FileWriter file = new FileWriter("datafile.txt", true);
            System.out.println("Hi");
            PrintWriter pw = new PrintWriter(file);
            pw.write(String.valueOf(person));
            pw.write("\n");
            pw.close();
        }catch (IOException e) {
            System.out.println("Error " + e);
        }

    }
}
