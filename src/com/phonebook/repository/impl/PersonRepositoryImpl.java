package com.phonebook.repository.impl;

import com.phonebook.model.Person;
import com.phonebook.repository.PersonRepository;

import java.io.*;

public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public boolean createPerson(Person person) {
        try {
            String line = null, lastLine = "";
            int idLast;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ((line = bufferedReader.readLine()) != null){
                lastLine = line;
                if (lastLine.split(" ")[1].equals(person.getSurname()) &&
                        lastLine.split(" ")[2].equals(person.getPhoneNumber())) {
                    return false;
                }
                lastLine = line;
            }
            idLast =  (lastLine == "") ?  0 : Integer.parseInt(lastLine.split(" ")[0]);
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("datafile.txt", true));
            if (idLast == 0){
                bufferedWriter.write((idLast + 1) + " " + person);
            } else {
                bufferedWriter.write("\n" + (idLast + 1) + " " + person);
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public String showAllPerson() {
        String strings = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            String line;
            while ( (line = bufferedReader.readLine()) != null){
                strings += line + "\n" ;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strings.equals("") ? null : strings;
    }

    @Override
    public String showNumberByName(String name) {
        String strings = "", line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ( (line = bufferedReader.readLine()) != null){
                if(line.split(" ")[1].equals(name)){
                    strings += line + "\n" ;
                }
            }
            bufferedReader.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strings.equals("") ? null : strings;
    }

    @Override
    public String showPersonByNumber(String number) {
        String strings = "", line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ( (line = bufferedReader.readLine()) != null){
                if(line.split(" ")[2].equals(number)){
                    strings += line + "\n" ;
                }
            }
            bufferedReader.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strings.equals("") ? null : strings;
    }

    @Override
    public boolean updatePerson(Person person) {
        String string = "", line;
        int index = 0;
        boolean isUpdate = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ( (line = bufferedReader.readLine()) != null){
                if(line.split(" ")[0].equals(person.getId())){
                    isUpdate = true;
                    string += ( index == 0 ) ? person.getId() + " " + person.toString() + "\n" :
                            "\n" + person.getId() + " " + person.toString();
                } else {
                    string += (index++ == 0) ? line : "\n" + line;
                }
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("datafile.txt", true));
            bufferedWriter.write(string);
            bufferedWriter.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return isUpdate;
    }

    @Override
    public boolean deleteById(String id) {
        String string="", line;
        boolean isDelete = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            int index = 0;
            while ( (line = bufferedReader.readLine()) != null){
                if(line.split(" ")[0].equals(id)){
                    isDelete = true;
                    continue;
                }
                string += (index++ == 0) ? line : "\n" + line;
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("datafile.txt"));
            bufferedWriter.write(string);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }

    @Override
    public String findByString(String string){
        String strings = "", line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ( (line = bufferedReader.readLine()) != null){
                if( line.split(" ")[1].toLowerCase().contains(string)){
                    strings += line + "\n" ;
                }
            }
            bufferedReader.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strings.equals("") ? null : strings;
    }
}
